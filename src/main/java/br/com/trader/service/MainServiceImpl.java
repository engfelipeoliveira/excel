package br.com.trader.service;

import static org.slf4j.LoggerFactory.getLogger;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class MainServiceImpl implements MainService {

	private static final Logger LOG = getLogger(MainServiceImpl.class);
	
	private ExcelService excelService;
	
	public MainServiceImpl(ExcelService excelService) {
		super();
		this.excelService = excelService;
	}

	@Override
	public void execute() throws Exception {
		this.excelService.read();
	}
	
	

}
