package applications.ProductCommentApps;

import dto.ProductCommentByUserIdDTO;
import entityservice.ProductCommentEntityService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class FindAllCommentsByUserIdAndRangeOfDates {

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
        List<ProductCommentByUserIdDTO> commentsList = service.findAllCommentsByUserIdAndRangeOfDates(1L,
                firstDateSimple, lastDateSimple);
        for (ProductCommentByUserIdDTO comment : commentsList) {
            System.out.println(comment);
        }
    }
}
