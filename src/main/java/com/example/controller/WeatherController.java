import com.example.model.WeatherResponse;
import com.example.service.WeatherService;
import com.example.util.WeatherUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WeatherController {

    private final WeatherService weatherService;
    private final WeatherUtils weatherUtils;

    @Autowired
    public WeatherController(WeatherService weatherService, WeatherUtils weatherUtils) {
        this.weatherService = weatherService;
        this.weatherUtils = weatherUtils;
    }

    @GetMapping("/weather")
    public String getWeather(Model model) {
        String weatherForecast = weatherService.getWeatherForecast();
        String weatherCondition = weatherUtils.getWeatherCondition(weatherForecast);

        WeatherResponse response = new WeatherResponse(weatherForecast, weatherCondition);
        model.addAttribute("weatherResponse", response);

        return "weather"; // Thymeleaf template name without the extension
    }
}
