package Controller;
import View.*;
import Model.*;
import View.ReportFrames.SavingFrame;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class Controller {
    private View view;
    private Model model;

    public Controller(View view, Model model){
        this.view=view;
        this.model=model;
        view.getSouthPanel().getCenterSubPanel().addAddCourseButtonListener(new AddCourseListener());
        view.getSouthPanel().getCenterSubPanel().addClearButtonListener(new ClearDataListener());
        view.getSouthPanel().getWestSubPanel().addCalculateButtonListener(new CalculateGPAListener());
        view.getSouthPanel().getEastSubPanel().addReportButtonListener(new CreateReportListener());
    }

    private class AddCourseListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            view.getCenterPanel().addCourse();
        }
    }

    private class ClearDataListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            view.getCenterPanel().clearFields();
            view.getSouthPanel().getWestSubPanel().resetGPA();
        }
    }

    private class CalculateGPAListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<String> names = new ArrayList<>();
            ArrayList<Float> grades = new ArrayList<>();
            ArrayList<Integer> ECTS = new ArrayList<>();
            dataProcessing(names, grades, ECTS, false);
        }
    }

    private class CreateReportListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            view.runPersonalDataFrame();
            view.getPersonalDataFrame().addConfirmButtonListener(new ConfirmButtonListener());
        }
    }

    private class ConfirmButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(!(view.getPersonalDataFrame().getStudentsID().getText().isEmpty()) && !(view.getPersonalDataFrame().getStudentsName().getText().isEmpty()) && !(view.getPersonalDataFrame().getStudentsSurname().getText().isEmpty()) && (isNumeric(view.getPersonalDataFrame().getStudentsID().getText()))){
                model.setStudentName(view.getPersonalDataFrame().getStudentsName().getText());
                model.setStudentSurname(view.getPersonalDataFrame().getStudentsSurname().getText());
                model.setStudentID(Long.valueOf(view.getPersonalDataFrame().getStudentsID().getText()));
                view.getPersonalDataFrame().dispose();
                ArrayList<String> names = new ArrayList<>();
                ArrayList<Float> grades = new ArrayList<>();
                ArrayList<Integer> ECTS = new ArrayList<>();
                dataProcessing(names, grades, ECTS, true);
            }else{
                view.showError("Wrong input! Please check if your data is correct");
            }
        }
    }

    private boolean isNumeric(String data) {
        if(data==null) return false;
        try {
            Long.parseLong(data);
        }catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private void createReport(){
        Document report = new Document(PageSize.A4);

        try{
            SavingFrame userPath = new SavingFrame();
            File userChoosenPath=userPath.getPaht();

            File reportFile;
            if(userChoosenPath!=null){
                reportFile=new File(userChoosenPath.getPath() +".pdf");
                FileOutputStream pdfFileout = new FileOutputStream(reportFile);
                PdfWriter.getInstance(report, pdfFileout);
                report.open();

                String line;
                Paragraph paragraph;
                PdfPCell cell;

                paragraph=new Paragraph("Grade Report", new Font(Font.FontFamily.TIMES_ROMAN, 30, Font.BOLD));
                paragraph.setAlignment(Paragraph.ALIGN_CENTER);
                report.add(paragraph);
                report.add(new Paragraph(" "));

                line="Grade Point Average: "+model.getGradePointAverage();
                paragraph = new Paragraph(line, new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.NORMAL));
                paragraph.setAlignment(Paragraph.ALIGN_LEFT);
                report.add(paragraph);
                report.add(new Paragraph(" "));

                PdfPTable table = new PdfPTable(3);
                table.setWidthPercentage(100);
                table.setSpacingBefore(10f);
                float[] columnWidths = {1f, 1f, 1f};
                table.setWidths(columnWidths);

                ArrayList<String> titles = new ArrayList<>();
                titles.add("Course name");
                titles.add("ECTS");
                titles.add("Grade");

                for(int i=0; i<3; i++){
                    paragraph = new Paragraph(titles.get(i), new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.NORMAL));
                    cell = new PdfPCell(paragraph);
                    cell.setBorderColor(BaseColor.BLACK);
                    cell.setPaddingLeft(10);
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    table.addCell(cell);
                }

                for(int i=0; i<model.getCourses().size(); i++){
                    paragraph = new Paragraph(model.getCourses().get(i).getName(), new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.NORMAL));
                    cell = new PdfPCell(paragraph);
                    cell.setBorderColor(BaseColor.BLACK);
                    cell.setPaddingLeft(10);
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    table.addCell(cell);

                    paragraph = new Paragraph(model.getCourses().get(i).getECTS().toString(), new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.NORMAL));
                    cell = new PdfPCell(paragraph);
                    cell.setBorderColor(BaseColor.BLACK);
                    cell.setPaddingLeft(10);
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    table.addCell(cell);

                    paragraph = new Paragraph(model.getCourses().get(i).getGrade().toString(), new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.NORMAL));
                    cell = new PdfPCell(paragraph);
                    cell.setBorderColor(BaseColor.BLACK);
                    cell.setPaddingLeft(10);
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    table.addCell(cell);
                }

                report.add(table);
                report.add(new Paragraph(""));
                report.close();
            }
            
        }catch(DocumentException exception){
            view.showError("PDF error!");
        }catch(FileNotFoundException exception){
            view.showError("There is no such a file!");
        }
    }

    private void dataProcessing(ArrayList<String> names, ArrayList<Float> grades, ArrayList<Integer> ECTS, boolean makeReport){
        try{
            for(int i=0; i<view.getCenterPanel().getCoursesNames().size(); i++){
                if((view.getCenterPanel().getCoursesNames().get(i).getText().isEmpty()) && (view.getCenterPanel().getGrades().get(i).getText().isEmpty()) && (view.getCenterPanel().getECTS().get(i).getText().isEmpty())) {
                    ;
                }else if(!(view.getCenterPanel().getCoursesNames().get(i).getText().isEmpty()) && !(view.getCenterPanel().getGrades().get(i).getText().isEmpty()) && !(view.getCenterPanel().getECTS().get(i).getText().isEmpty())){
                    names.add(view.getCenterPanel().getCoursesNames().get(i).getText());
                    ECTS.add(Integer.valueOf(view.getCenterPanel().getECTS().get(i).getText()));
                    grades.add(Float.valueOf(view.getCenterPanel().getGrades().get(i).getText()));
                }else{
                    throw new NotEnoughDataException();
                }
            }
            model.updateCourses(names, ECTS, grades);
            model.calculateGPA();
            view.setGPA(model.getGradePointAverage().toString());
            if(makeReport){
                createReport();
            }
        }catch(NumberFormatException exception){
            view.showError("Wrong input! Please check if your data is correct");
        }catch(NotEnoughDataException exception){
            view.showError("Not enough data was given!");
        }
    }
}
