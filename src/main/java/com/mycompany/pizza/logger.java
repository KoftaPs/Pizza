package com.mycompany.pizza;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class logger implements Logger{
    
    @Override
    public void Log(String msg,boolean saveToFile)
    {
        if(saveToFile)
        {
            try {
                
               
                
                
                File f1 = new File("logs.txt");
                
                if(!f1.exists())
                {
                    f1.createNewFile();
                }
                
                String prev_logs = "";
                FileInputStream in = new FileInputStream(f1);
                
                int i = in.read();
                
                while(i != -1)
                {
                    prev_logs += (char)i;
                    
                    i = in.read();
                }
                
                in.close();
                
                
                File f2 = new File("logs.txt");
                
                FileOutputStream out = new FileOutputStream(f2);
                
                
                out.write((prev_logs+msg).getBytes());
                
                out.close();

                
            } catch (Exception e) {
                
                e.printStackTrace();
            }
            
            
            
        }
        else
        {
            System.out.println(msg);
        }
   
    }
    
}
