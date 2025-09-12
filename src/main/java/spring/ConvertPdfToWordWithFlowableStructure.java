package spring;

import com.spire.pdf.FileFormat;
import com.spire.pdf.PdfDocument;
 
public class ConvertPdfToWordWithFlowableStructure {
 
    public static void main(String[] args) {
 
        //创建一个 PdfDocument 对象
        PdfDocument doc = new PdfDocument();
 
        //加载 PDF 文件
        doc.loadFromFile("/Users/chenyves/Desktop/考勤管理制度.pdf");
 
        //将 PDF 转换为流动形态的Word
        doc.getConvertOptions().setConvertToWordUsingFlow(true);
 
        //将PDF转换为Doc格式文件并保存
        doc.saveToFile("/Users/chenyves/Desktop/考勤管理制度.doc", FileFormat.DOC);
 
        //将PDF转换为Docx格式文件并保存
        doc.saveToFile("/Users/chenyves/Desktop/考勤管理制度.docx", FileFormat.DOCX);
        doc.close();
    }
}