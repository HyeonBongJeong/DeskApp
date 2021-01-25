package com.kh.wefer.payment.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.wefer.payment.model.dao.AnnualDao;
import com.kh.wefer.payment.model.dao.PaymentDao;
import com.kh.wefer.payment.model.dao.Payment_confrimDao;
import com.kh.wefer.payment.model.domain.Annual;
import com.kh.wefer.payment.model.domain.Payment;
import com.kh.wefer.payment.model.domain.Payment_confirm;

@Service("aService")
public class AnnualServiceImpl implements AnnualService {
	@Autowired
	private AnnualDao aDao;
	@Autowired
	private PaymentDao pmDao;
	@Autowired
	private Payment_confrimDao pcDao;
	@Override
	public int insertAnnual(Annual a) {
		return aDao.insertAnnual(a);
	}
	@Override
	public int insertAnnualPayment(Annual a, Payment b) {
		String seq = aDao.seqAnnualPayment();
		System.out.println("anuual�μ�Ʈ�Ҷ� �ܷ�Ű "+ seq);
		a.setAnnual_id(seq);
		b.setAnnual_id(seq);
		
		String seqc = pmDao.seqPayment();
		System.out.println("���� �����ڶ� �ܷ�Ű Payment_id seq: "+ seqc);
		b.setPayment_id(seqc);
		
		int resultA = aDao.insertAnnual(a);
		int resultB= pmDao.insertPayment(b);
		int resultC= pcDao.insertPaymentConfirm(b);
		
		if(resultA==1 || resultB==1 || resultC==1)
			return 1;
		else
			return 0;
	}
	@Override
	public void deleteAnnual(String hcid) {
		
		aDao.deleteAnnual(hcid);
		
	}

}
