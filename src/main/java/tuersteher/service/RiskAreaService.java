package tuersteher.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.annotation.Documented;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Robert Rabe on 22.03.20.
 */
@Service
public class RiskAreaService {
    private static String BASE_URL = "https://www.rki.de/DE/Content/InfAZ/N/Neuartiges_Coronavirus/Risikogebiete.html";

    private Logger logger = LoggerFactory.getLogger(RiskAreaService.class);

    @Cacheable("riskAreas")
    public List<String> getRiskAreas() {
        logger.info("Retrieving risk areas from RKI");
        Document doc;

        try {
            doc = Jsoup.connect(BASE_URL).get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Elements infoBoxes = doc.getElementsByClass("infobox breit");
        return infoBoxes.stream().flatMap(box -> {
            Elements infos = box.getElementsByTag("p");
            StringBuilder builder = new StringBuilder();

            List<String> toReturn = new ArrayList<>();

            for (Element info : infos.stream().flatMap(i -> i.children().stream()).collect(Collectors.toList())) {
                if (info.tag().toString().equals("strong")) {
                    if (builder.length() != 0) {
                        toReturn.add(builder.toString());
                    }

                    builder = new StringBuilder();
                    builder.append(info.text().replace(":", ""));
                }
            }

            return toReturn.stream();
        }).collect(Collectors.toList());
    }
}
