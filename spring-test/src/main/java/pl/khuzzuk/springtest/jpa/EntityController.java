package pl.khuzzuk.springtest.jpa;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("entity")
public class EntityController {
    private MyEntityRepo myEntityRepo;

    @PostMapping("create")
    public MyEntity save(@RequestBody MyEntity myEntity) {
        return myEntityRepo.save(myEntity);
    }
}
