package microservicefdcalculator.fdcalculator;

import microservicefdcalculator.fdcalculator.beans.FDEntities;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

@RestController
public class CalculatorController {

    @Value("${dbname}")
    String dbname;

    @GetMapping("/fdCalculator/amount/{amount}/years/{years}")
    public String getMaturityAmount(@PathVariable long amount, @PathVariable int years){
        File file = new File("D:\\Work\\Microservices\\db\\"+dbname+".txt");
        float interestRate = 1;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String strInterestRate = br.readLine();
            if(strInterestRate.length() > 0){
                String[] arr = strInterestRate.split("=");
                interestRate = Float.parseFloat(arr[1]);
            }
        } catch ( IOException | NumberFormatException e ) {
            e.printStackTrace();
        }

        FDEntities obj = new FDEntities(amount,years,interestRate);
        return "Maturity amount would be: "+obj.getMaturityAmount();
    }
}
