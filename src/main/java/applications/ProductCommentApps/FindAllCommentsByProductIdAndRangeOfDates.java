package applications.ProductCommentApps;

import dto.ProductCommentsByProductIdAndRangeOfDatesDTO;
import entityservice.ProductCommentEntityService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class FindAllCommentsByProductIdAndRangeOfDates {

    public static void main(String[] args) throws ParseException {

        System.out.println("dd-mm-yyyy");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter first date");
        String firstDate = scanner.nextLine();
        Date firstDateSimple = new SimpleDateFormat("dd-MM-yyyy").parse(firstDate);
        System.out.println("----------------");
        System.out.println("Please enter last date");
        String lastDate = scanner.nextLine();
        Date lastDateSimple = new SimpleDateFormat("dd-MM-yyyy").parse(lastDate);

        ProductCommentEntityService service = new ProductCommentEntityService();
        List<ProductCommentsByProductIdAndRangeOfDatesDTO> commentsList = service.findAllCommentsByProductIdAndRangeOfDates(1L,
                firstDateSimple, lastDateSimple);
        for (ProductCommentsByProductIdAndRangeOfDatesDTO comment : commentsList) {
            System.out.println(comment);
        }
    }
}
