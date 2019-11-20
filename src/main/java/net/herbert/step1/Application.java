package net.herbert.step1;

import com.opencsv.bean.CsvToBeanBuilder;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import net.herbert.step1.model.City;

import java.io.FileReader;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.List;
import java.util.stream.Collectors;

public class Application {

    public static void main(String... args) throws IOException {
        var server = HttpServer.create(new InetSocketAddress(8080), 0);
        var context = server.createContext("/cities");
        context.setHandler(Application::handleRequest);
        server.start();
    }

    private static void handleRequest(HttpExchange exchange) throws IOException {
        var response = getCitiesFromCsv().stream()
                .map(City::getName)
                .collect(Collectors.joining(","));
        exchange.sendResponseHeaders(200, response.getBytes().length);
        try (var output = exchange.getResponseBody()) {
            output.write(response.getBytes());
        }
    }

    private static List<City> getCitiesFromCsv() throws IOException {
        try (var reader = new FileReader("cities.csv")) {
            return new CsvToBeanBuilder<City>(reader)
                    .withType(City.class)
                    .build()
                    .parse();
        }
    }
}
