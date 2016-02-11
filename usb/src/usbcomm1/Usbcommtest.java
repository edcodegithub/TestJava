/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usbcomm1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.List;

import javax.usb.UsbConfiguration;
import javax.usb.UsbConst;
import javax.usb.UsbControlIrp;
import javax.usb.UsbDevice;
import javax.usb.UsbDeviceDescriptor;
import javax.usb.UsbEndpoint;
import javax.usb.UsbException;
import javax.usb.UsbHostManager;
import javax.usb.UsbHub;
import javax.usb.UsbInterface;
import javax.usb.UsbPipe;
/**
 *
 * @author Srinath Ramesh
 */
public class Usbcommtest {
    
     
private static final short VENDOR_ID = 0x1cbe;

private static final short PRODUCT_ID = 0x0003;
/**
	 * @param args
	 * @throws UsbException 
	 * @throws SecurityException 
	 */
	public static void main(String[] args) throws SecurityException, UsbException {
		// TODO Auto-generated method stub
		final short vendor = 0x1cbe;

		final short product = 0x0003;

		UsbDevice myDevice = findDevice(UsbHostManager.getUsbServices().getRootUsbHub(),vendor, product);
		System.out.println(myDevice);
		
		UsbControlIrp irp = myDevice.createUsbControlIrp(
			    (byte) (UsbConst.REQUESTTYPE_DIRECTION_IN
			          | UsbConst.REQUESTTYPE_TYPE_STANDARD
			          | UsbConst.REQUESTTYPE_RECIPIENT_DEVICE),
			    UsbConst.REQUEST_GET_CONFIGURATION,
			    (short) 0,
			    (short) 0
			    );
			
			irp.setData(new byte[1]);
			myDevice.syncSubmit(irp);
			System.out.println(irp.getData()[0]);
			
			UsbConfiguration configuration = myDevice.getActiveUsbConfiguration();
			System.out.println(configuration);
			UsbInterface iface = configuration.getUsbInterface((byte) 0);
			System.out.println(iface);
			iface.claim();
			try
			{	
				UsbEndpoint endpoint = iface.getUsbEndpoint((byte) 1);
				UsbPipe pipe = endpoint.getUsbPipe();
				pipe.open();
				 BufferedReader inp = new BufferedReader (new InputStreamReader(System.in));
				 System.out.println("Enter the input string");
				    
				try
				{
					String T= inp.readLine();
					char[] c=T.toCharArray();
					byte[] bytes =  Charset.forName("UTF-8").encode(CharBuffer.wrap(c)).array();
				    int sent = pipe.syncSubmit(bytes );//{ 'a','b'}
				    System.out.println(sent + " bytes sent");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally
				{
				    pipe.close();
				}
                                 endpoint = iface.getUsbEndpoint((byte) 0x81);
				 pipe = endpoint.getUsbPipe();
				 pipe.open();
                            try {
                                byte[] data = new byte[256];
                                int received = pipe.syncSubmit(data);
                                double val;
                                val = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN ).getDouble();
                                for(int iu=0;iu<data.length;iu++){
                                	//System.out.print(received + " bytes received"+"   "+(char)data[0]+(char)data[1]);
                                	if(iu==0){
                                	System.out.println(received + " bytes received"+"   ");
                                	}System.out.print((char)data[iu]);
                                }
                                System.out.println();
                                
                            } finally {
                                pipe.close();
                            }
			    
			}
			finally        
			{
			    iface.release();
			}
	}
	
	public static UsbDevice findDevice(UsbHub hub, short vendorId, short productId)
	{
	    for (UsbDevice device : (List<UsbDevice>) hub.getAttachedUsbDevices())
	    {
	        UsbDeviceDescriptor desc = device.getUsbDeviceDescriptor();
	        if (desc.idVendor() == vendorId && desc.idProduct() == productId) return device;
	        if (device.isUsbHub())
	        {
	            device = findDevice((UsbHub) device, vendorId, productId);
	            if (device != null) return device;
	        }
	    }
	    return null;
	}
}
