package kodlamaio.hrms.core.adapter;

import java.rmi.RemoteException;

import kodlamaio.hrms.entities.concretes.Candidate;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoap;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisServiceAdapter implements MernisService{

	@Override
	public boolean checkIfRealPerson(Candidate candidate) {
		
			
			boolean result;
			KPSPublicSoap kpsPublicSoapProxy = new KPSPublicSoapProxy(); 
			try { 
				result = kpsPublicSoapProxy.TCKimlikNoDogrula(
						Long.parseLong(candidate.getNationalityId()),					
						candidate.getFirstName().toUpperCase(),
					    candidate.getLastName().toUpperCase(),
						candidate.getDateOfBirth().getYear()); 
			}
		    catch (RemoteException e) { 
				result = false; 
				e.printStackTrace(); 
			}
			
			return result;
			
		
	}

}
