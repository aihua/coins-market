package functional.com.app.coins.service;

import com.app.coins.domain.Country;
import com.app.coins.domain.Subscriber;
import com.app.coins.service.CountryService;
import com.app.coins.service.SubscriberService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/test-context.xml")
public class SubscriberServiceTest {

    @Autowired
    private SubscriberService subscriberService;

    @Autowired
    private CountryService countryService;

    @Test
    @Ignore
    public void testSave() throws Exception {
        Subscriber subscriber = new Subscriber();
        subscriber.setEmail("Papercut@user.com");
        Country country = countryService.read("UK");
        Set<Country> countries = new HashSet<Country>();
        countries.add(country);
        subscriber.setCountries(countries);
        subscriberService.save(subscriber);
    }

    @Test
    public void testRead() throws Exception {

    }

    @Test
    public void testReadAll() throws Exception {

    }

    @Test
    public void testUpdate() throws Exception {

    }

    @Test
    @Ignore
    public void testDelete() throws Exception {
        Subscriber subscriber = subscriberService.read("Papercut@user.com");
        subscriberService.delete(subscriber);
    }
}