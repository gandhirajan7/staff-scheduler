package algorithm.service;

import com.scheduler.app.StaffSchedulerApplication;
import com.scheduler.app.algorithm.model.entity.EmpHistoryPOJO;
import com.scheduler.app.algorithm.model.repo.EmployeeHistoryRepository;
import com.scheduler.app.algorithm.service.AlgorithmServiceImpl;
import com.scheduler.app.supervisor.service.SchedulerServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = StaffSchedulerApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource(
        locations = "classpath:application.test.properties")
public class AlgorithmServiceImplUnitTest {

    public static final int HOURS = 1;
    @InjectMocks
    private AlgorithmServiceImpl algorithmService = new AlgorithmServiceImpl();

    @Mock
    private EmployeeHistoryRepository employeeHistoryRepository;

    @Test
    public void testUpdateEmployeeHistory(){
        EmpHistoryPOJO empHistoryPOJO = new EmpHistoryPOJO();
        when(employeeHistoryRepository.findDistinctTopByEmployeeId(any())).thenReturn(empHistoryPOJO);
        when(employeeHistoryRepository.saveAndFlush(any())).thenReturn(empHistoryPOJO);
        algorithmService.updateEmployeeHistory(HOURS,2);

    }
}
