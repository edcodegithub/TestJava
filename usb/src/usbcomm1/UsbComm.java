package usbcomm1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.DoubleBuffer;
import java.nio.IntBuffer;
import java.util.List;

import javax.usb.UsbClaimException;
import javax.usb.UsbConfiguration;
import javax.usb.UsbConst;
import javax.usb.UsbControlIrp;
import javax.usb.UsbDevice;
import javax.usb.UsbDeviceDescriptor;
import javax.usb.UsbDisconnectedException;
import javax.usb.UsbEndpoint;
import javax.usb.UsbException;
import javax.usb.UsbHostManager;
import javax.usb.UsbHub;
import javax.usb.UsbInterface;
import javax.usb.UsbInterfacePolicy;
import javax.usb.UsbIrp;
import javax.usb.UsbNotActiveException;
import javax.usb.UsbNotClaimedException;
import javax.usb.UsbPipe;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

public class UsbComm {

	/**
	 * @param args
	 * @throws UsbDisconnectedException
	 * @throws IllegalArgumentException
	 * @throws UsbException
	 * @throws SecurityException
	 */

	// variable declaration
	public static UsbDevice myDevice;
	public UsbControlIrp irp;
	final short vendor = 0x1cbe;
	final short product = 0x0003;
	public double sent, numBodies, mode, weeks, days;
	public FileReader fr;
	public double Mass, Px, Py, Vx, Vy;
	public double sendarr[] = new double[5];
	public byte[] senddata = new byte[40];
	public byte[] sendinit = new byte[24];
	byte[] body_params = new byte[40];
	public double[] send_Init = new double[3];
	public byte[] init_params = new byte[24];
	public byte[] recvData = new byte[40];
	public FileWriter fw;
	public BufferedWriter bw;
	public double[] recvval;
	int count = 0;

	// constructor to initialize my device and create controlIrp
	public UsbComm() throws IllegalArgumentException, UsbDisconnectedException,
			UsbException {

		myDevice = findDevice(UsbHostManager.getUsbServices().getRootUsbHub(),
				vendor, product);
		//System.out.println(myDevice);

		irp = myDevice
				.createUsbControlIrp(
						(byte) (UsbConst.REQUESTTYPE_DIRECTION_IN
								| UsbConst.REQUESTTYPE_TYPE_STANDARD | UsbConst.REQUESTTYPE_RECIPIENT_DEVICE),
						UsbConst.REQUEST_GET_CONFIGURATION, (short) 0,
						(short) 0);

		irp.setData(new byte[1]);
		myDevice.syncSubmit(irp);
	}

	// method to send initial values to the controller
	public void sendInitialParams() throws UsbNotActiveException,
			UsbNotClaimedException, UsbDisconnectedException, UsbException,
			IOException {
		UsbConfiguration configuration = myDevice.getActiveUsbConfiguration();
		//System.out.println(configuration);
		UsbInterface iface = configuration.getUsbInterface((byte) 0);
		//System.out.println(iface);
		iface.claim();

		try {
			UsbEndpoint endpoint = iface.getUsbEndpoint((byte) 1);
			UsbPipe pipe = endpoint.getUsbPipe();
			pipe.open();
			try {
				fr = new FileReader("F:/eclipseworkspace/GUI/src/init.txt");
				LineNumberReader lnr = new LineNumberReader(fr);
				String str = lnr.readLine();
				mode = Double.parseDouble(str);
				str = lnr.readLine();
				numBodies = Double.parseDouble(str);
				str = lnr.readLine();
				weeks = Double.parseDouble(str);
				str = lnr.readLine();
				days = Double.parseDouble(str);
				send_Init[0] = mode;
				send_Init[1] = numBodies;
				double iteration = ((weeks * 7) + days);
				send_Init[2] = iteration;
				// send_Init[3] = days;
				init_params = DoubleArray2ByteArray(send_Init);
				ByteBuffer.wrap(sendinit).order(ByteOrder.LITTLE_ENDIAN)
						.put(init_params);
				sent = pipe.syncSubmit(sendinit);
				//System.out.println("sent initial params");
				String line = lnr.readLine();
				try {
					while (line.isEmpty()) {
						int num = lnr.getLineNumber();
						lnr.setLineNumber(num);
						String string = lnr.readLine();
						if ((!string.isEmpty())) {
							Mass = Double.parseDouble(string);
							string = lnr.readLine();
							Px = Double.parseDouble(string);
							string = lnr.readLine();
							Py = Double.parseDouble(string);
							string = lnr.readLine();
							Vx = Double.parseDouble(string);
							string = lnr.readLine();
							Vy = Double.parseDouble(string);
							line = lnr.readLine();
							sendarr[0] = Mass;
							sendarr[1] = Px;
							sendarr[2] = Py;
							sendarr[3] = Vx;
							sendarr[4] = Vy;
							body_params = DoubleArray2ByteArray(sendarr);
							ByteBuffer.wrap(senddata)
									.order(ByteOrder.LITTLE_ENDIAN)
									.put(body_params);
							sent = pipe.syncSubmit(senddata);
							//System.out.println("Sent Mass values");
						} else {
							System.out.println("EOF");
						}
					}
				} catch (Exception e) {
					//System.out.println("end");
				}
				fr.close();
			} finally {
				pipe.close();
			}
		} finally {
			iface.release();
		}
		//return send_Init;
	}

	// method to convert double array to byte array
	public static byte[] DoubleArray2ByteArray(double[] values) {
		ByteBuffer buffer = ByteBuffer.allocate(8 * values.length);
		for (double value : values) {
			buffer.order(ByteOrder.LITTLE_ENDIAN).putDouble(value);
		}
		return buffer.array();
	}

	// method to convert int array to byte array
	public static byte[] IntArray2ByteArray(int[] values) {
		ByteBuffer buffer = ByteBuffer.allocate(4 * values.length);
		for (int value : values) {
			buffer.putInt(value);
		}
		return buffer.array();

	}

	// method to receive data from the controller

	public double[] receiveValFromCont() throws UsbClaimException,
			UsbNotActiveException, UsbDisconnectedException, UsbException,
			IOException {
		double[] returnval = new double[3];
		UsbConfiguration configuration = myDevice.getActiveUsbConfiguration();
		//System.out.println(configuration);
		UsbInterface iface = configuration.getUsbInterface((byte) 0);
		//System.out.println(iface);
		iface.claim();
		try {

			UsbEndpoint endpoint = iface.getUsbEndpoint((byte) 0x81);
			UsbPipe pipe = endpoint.getUsbPipe();
			pipe.open();
			try {
				
				int received = pipe.syncSubmit(recvData);
				DoubleBuffer recv;
				// for(int m = 0; m<numBodies; m++){
				// recv =
				// ByteBuffer.wrap(recvData).order(ByteOrder.LITTLE_ENDIAN).get(body_final).asDoubleBuffer();
				// double recve =
				// ByteBuffer.wrap(recvData).order(ByteOrder.LITTLE_ENDIAN).getDouble();
				// double[] copy = new double[recv.remaining()];
				ByteBuffer buf2 = ByteBuffer.wrap(recvData).order(
						ByteOrder.LITTLE_ENDIAN);
				recvval = new double[recvData.length / 8];
				//System.out.println("receive val" + recvval.length);
				for (int i = 0; i < recvval.length; i++) {
					recvval[i] = buf2.getDouble(i * 8);
					//System.out.println(recvval[i]);
					if(count==0 && i==0){
						//System.out.println(recvval[i]);
					}
					count++;
					if(count==numBodies){
						count = 0;
					}
					// }
					if(mode==0){
						//System.out.println("entered");
						fw = new FileWriter(
								"F:/eclipseworkspace/GUI/src/final.txt", true);
						bw = new BufferedWriter(fw);
						for (int k = 0; k < recvval.length; k++) {
							//System.out.println(recvval[k]);
							String str = String.valueOf(recvval[k]);
							//bw.write(k);
							bw.write(str);
							bw.newLine();
						}
						bw.newLine();
					}
					else{
						
						fw = new FileWriter(
								"F:/eclipseworkspace/GUI/src/viz.txt", true);
						bw = new BufferedWriter(fw);
						//int index = (int)recvval[0];
						returnval[0] = recvval[0];
						returnval[1] = recvval[2];
						returnval[2] = recvval[3];
						
						for (int k = 0; k < recvval.length; k++) {
							String str = String.valueOf(recvval[k]);
							//bw.write(k);
							bw.write(str);
							bw.newLine();
						}
						bw.newLine();
					}
					

				}

				//System.out.println(received + " bytes received");
			} finally {
				pipe.close();
				bw.close();
				fw.close();
			}
		} finally {
			iface.release();
		}
		if((returnval[0] > numBodies) && (returnval[0] < 0)){
			return null;
		}
		else
		return returnval;
	}

	// method to find my device
	public static UsbDevice findDevice(UsbHub hub, short vendorId,
			short productId) {
		for (UsbDevice device : (List<UsbDevice>) hub.getAttachedUsbDevices()) {
			UsbDeviceDescriptor desc = device.getUsbDeviceDescriptor();
			if (desc.idVendor() == vendorId && desc.idProduct() == productId)
				return device;
			if (device.isUsbHub()) {
				device = findDevice((UsbHub) device, vendorId, productId);
				if (device != null)
					return device;
			}
		}
		return null;
	}

}

