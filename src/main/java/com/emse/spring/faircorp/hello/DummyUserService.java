package com.emse.spring.faircorp.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DummyUserService implements UserService {
    @Autowired
    private ConsoleGreetingService GreetingService;
    List<String> ListNames = List.of("Elodie", "Charles");

    @Override
    public void greetAll() {
        for (int i = 0; i < ListNames.size(); i++) GreetingService.greet(ListNames.get(i));
    }
}
