package cn.ahpu.medicinal;

import cn.ahpu.medicinal.impl.MedicinalDaoImpl;
import cn.ahpu.medicinal.impl.MedicinalTableDaoImpl;
import cn.ahpu.medicinal.pojo.Medicinal;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
class MedicinalApplicationTests {

	@Autowired
	MedicinalTableDaoImpl tableDao;

	@Autowired
	MedicinalDaoImpl medicinalDao;

	@Test
	public int testConnection(){
//		List<MedicinalTable> medicinalTables = tableDao.findAllIn();
//		return medicinalTables.size();

		List<Medicinal> medicinals = medicinalDao.findAll();
		return medicinals.size();
	}

	@Test
	int contextLoads() {
		List<Medicinal> medicinals = medicinalDao.findAll();
		return medicinals.size();
	}

}
