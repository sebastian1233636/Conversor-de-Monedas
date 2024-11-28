package Logic;

public class Result {

    private String conversionResult;


    public Result(String conversionResult) {
        this.conversionResult = conversionResult;
    }

    public Result(resultOmdb resultOmdb) {
        this.conversionResult = resultOmdb.conversion_result();
    }


    public String getConversionResult() {
        return conversionResult;
    }

    public void setConversionResult(String conversionResult) {
        this.conversionResult = conversionResult;
    }


    @Override
    public String toString() {
        return  conversionResult;
    }
}
