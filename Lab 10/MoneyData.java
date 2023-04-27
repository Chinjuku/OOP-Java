import java.math.BigDecimal;
import java.util.*;

public class MoneyData {
    private Map<String, Object> data;

    public MoneyData() {
        data = new HashMap<>();
    }

    public void saveMoney(BigDecimal amount) {
        data.put("money", amount);
    }

    public BigDecimal getMoney() {
        return (BigDecimal) data.getOrDefault("money", BigDecimal.ZERO);
    }
}
