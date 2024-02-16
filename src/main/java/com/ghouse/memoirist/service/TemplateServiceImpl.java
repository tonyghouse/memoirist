package com.ghouse.memoirist.service;

import com.ghouse.memoirist.dto.TemplateDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemplateServiceImpl implements TemplateService {

	Logger log = LoggerFactory.getLogger(TemplateServiceImpl.class);

	@Override
	public List<TemplateDetails> getTopTemplates() {
		// TODO Auto-generated method stub
		return null;
	}

//	@Autowired
//	private TemplateRepo TemplateRepo;
//
//	@Autowired
//	private TemplateMapper TemplateMapper;

}
