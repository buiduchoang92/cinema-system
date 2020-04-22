package codegym.module4.QuocVietPackage.Controllers;


import codegym.module4.QuocVietPackage.Entities.point;
import codegym.module4.QuocVietPackage.Entities.user;
import codegym.module4.QuocVietPackage.Services.pointService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(PointController.BASE_URL)
public class PointController {

    public static final String BASE_URL = "/api/v1/point";
    private final pointService pointService;

    public PointController(pointService pointService) {
        this.pointService = pointService;
    }

    @GetMapping
    public List<point> getAllPoint() {
        return pointService.findAllPoint();
    }


    @GetMapping("/{id}")
    public List<point> getPointDetails(@PathVariable user id) {



        return pointService.findPointByDate(id);
    }


    @GetMapping("{id}/{from}/{to}")
    public List<point> getPointDetailsDate(@PathVariable user id,@PathVariable("from") @DateTimeFormat(pattern="yyyy-MM-dd") Date from,@PathVariable("to") @DateTimeFormat(pattern="yyyy-MM-dd") Date to) {

System.out.println(from);
System.out.println(to);

        return pointService.findPointByDate2(from, to, id);
    }
}
