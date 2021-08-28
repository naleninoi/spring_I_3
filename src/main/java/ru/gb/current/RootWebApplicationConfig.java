package ru.gb.current;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.gb.prev.AppConfiguration;

@Configuration
@Import(AppConfiguration.class)
public class RootWebApplicationConfig{
}
