package com.zx.service;

import com.google.zxing.Binarizer;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import javax.imageio.ImageIO;

/**
 * @author gzx
 * @date 2021/7/6 14:50
 */
public class AnalysisQRCode {

  public static void main(String[] args) {

    MultiFormatReader formatReader = new MultiFormatReader();

    try {
      File file = new File("D:/img.png");
      BufferedImage image = ImageIO.read(file);
      LuminanceSource source = new BufferedImageLuminanceSource(image);
      Binarizer binarizer = new HybridBinarizer(source);

      BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);

      HashMap hints = new HashMap<>();
      hints.put(EncodeHintType.CHARACTER_SET, "utf-8");

      Result result = formatReader.decode(binaryBitmap, hints);

      System.out.println(result.toString());
      System.out.println(result.getText());
    } catch (Exception e) {
      System.err.println(e);
    }
  }

}
