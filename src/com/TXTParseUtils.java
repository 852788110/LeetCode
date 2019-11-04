package com;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**

 *

 * 功能：获取文本内容<br>

 * 作者：张tt<br>

 * 时间：2017年8月10日<br>

 * 版本：1.0<br>

 *

 */

public class TXTParseUtils {
    public static List<String> readTxtFile(String filePath) throws IOException {
        String encoding = "UTF-16";
        File file = new File(filePath);

        // 判断文件是否存在
        if (file.isFile() && file.exists() && file.canRead()) {
            List<String> result = new ArrayList<>();
            FileInputStream fiStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fiStream, encoding);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String text = null;
            /**row表示行数*/

            int row = 1;
            while ((text = bufferedReader.readLine()) != null) {
                if (text.length()>3&&text.charAt(2)==':'&&text.charAt(0)>='0'&&text.charAt(0)<='9') {
                    result.add(text + System.lineSeparator());
                }
                row++;
            }

            bufferedReader.close();
            inputStreamReader.close();
            fiStream.close();
            return result;
        }
        return null;
    }

    public static List<Integer> encoding(List<String> strings){
        List<Integer> ans=new ArrayList<>();
        for (String s:strings){
            int position=0;
            String temp=s.substring(16).trim();
            String[] temp1=temp.split(":");
            String[] temp2=temp1[2].split(",");
            temp1[2]=null;
            position+=Integer.valueOf(temp1[0])*3600*1000;
            position+=Integer.valueOf(temp1[1])*60*1000;
            position+=Integer.valueOf(temp2[0])*1000;
            position+=Integer.valueOf(temp2[1]);
            ans.add(position);
        }
        return ans;
    }

}

