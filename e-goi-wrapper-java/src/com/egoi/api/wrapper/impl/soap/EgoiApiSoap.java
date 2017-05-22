package com.egoi.api.wrapper.impl.soap;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import com.egoi.api.soap.any.Egoi_Api_SoapPort;
import com.egoi.api.soap.any.Egoi_Api_SoapServiceLocator;
import com.egoi.api.wrapper.api.EgoiMap;
import com.egoi.api.wrapper.api.EgoiMapList;
import com.egoi.api.wrapper.api.exceptions.EgoiException;
import com.egoi.api.wrapper.impl.AbstractEgoiApi;

public class EgoiApiSoap extends AbstractEgoiApi {

	private Egoi_Api_SoapPort api;
	
	public EgoiApiSoap() throws ServiceException {
		Egoi_Api_SoapServiceLocator loc = new Egoi_Api_SoapServiceLocator();
		api = loc.getEgoi_Api_SoapPort();
	}
	
	@Override
	public EgoiMap addExtraField(EgoiMap arguments) throws EgoiException {
		try {
			return decodeResult(api.addExtraField(arguments), EgoiMap.class);
		} catch (RemoteException e) {
			throw new EgoiException(e.getMessage(), e);
		}		
	}
	
	@Override
	public EgoiMap getUserData(EgoiMap arguments) throws EgoiException {
		try {
			return decodeResult(api.getUserData(arguments), EgoiMap.class);
		} catch (RemoteException e) {
			throw new EgoiException(e.getMessage(), e);
		}
	}

	@Override
	public EgoiMap addSubscriber(EgoiMap arguments) throws EgoiException {
		try {
			return decodeResult(api.addSubscriber(arguments), EgoiMap.class);
		} catch (RemoteException e) {
			throw new EgoiException(e.getMessage(), e);
		}
	}

	@Override
	public EgoiMap addSubscriberBulk(EgoiMap arguments) throws EgoiException {
		try {
			return decodeResult(api.addSubscriberBulk(arguments), EgoiMap.class);
		} catch (RemoteException e) {
			throw new EgoiException(e.getMessage(), e);
		}
	}

	@Override
	public EgoiMapList getLists(EgoiMap arguments) throws EgoiException {
		try {
			return decodeResult(api.getLists(arguments), EgoiMapList.class);
		} catch (RemoteException e) {
			throw new EgoiException(e.getMessage(), e);
		}
	}

	@Override
	public EgoiMap checkLogin(EgoiMap arguments) throws EgoiException {
		try {
			return decodeResult(api.checkLogin(arguments), EgoiMap.class);
		} catch (RemoteException e) {
			throw new EgoiException(e.getMessage(), e);
		}
	}

	@Override
	public EgoiMap createCampaignEmail(EgoiMap arguments) throws EgoiException {
		try {
			return decodeResult(api.createCampaignEmail(arguments), EgoiMap.class);
		} catch (RemoteException e) {
			throw new EgoiException(e.getMessage(), e);
		}
	}

	@Override
	public EgoiMap createCampaignFAX(EgoiMap arguments) throws EgoiException {
		try {
			return decodeResult(api.createCampaignFAX(arguments), EgoiMap.class);
		} catch (RemoteException e) {
			throw new EgoiException(e.getMessage(), e);
		}
	}

	@Override
	public EgoiMap createCampaignSMS(EgoiMap arguments) throws EgoiException {
		try {
			return decodeResult(api.createCampaignSMS(arguments), EgoiMap.class);
		} catch (RemoteException e) {
			throw new EgoiException(e.getMessage(), e);
		}
	}

	@Override
	public EgoiMap createCampaignVoice(EgoiMap arguments) throws EgoiException {
		try {
			return decodeResult(api.createCampaignVoice(arguments), EgoiMap.class);
		} catch (RemoteException e) {
			throw new EgoiException(e.getMessage(), e);
		}
	}

	@Override
	public EgoiMap createList(EgoiMap arguments) throws EgoiException {
		try {
			return decodeResult(api.createList(arguments), EgoiMap.class);
		} catch (RemoteException e) {
			throw new EgoiException(e.getMessage(), e);
		}
	}

	@Override
	public EgoiMap createSegment(EgoiMap arguments) throws EgoiException {
		try {
			return decodeResult(api.createSegment(arguments), EgoiMap.class);
		} catch (RemoteException e) {
			throw new EgoiException(e.getMessage(), e);
		}
	}

	@Override
	public EgoiMap deleteCampaign(EgoiMap arguments) throws EgoiException {
		try {
			return decodeResult(api.deleteCampaign(arguments), EgoiMap.class);
		} catch (RemoteException e) {
			throw new EgoiException(e.getMessage(), e);
		}
	}

	@Override
	public EgoiMap deleteList(EgoiMap arguments) throws EgoiException {
		try {
			return decodeResult(api.deleteList(arguments), EgoiMap.class);
		} catch (RemoteException e) {
			throw new EgoiException(e.getMessage(), e);
		}
	}

	@Override
	public EgoiMap deleteSegment(EgoiMap arguments) throws EgoiException {
		try {
			return decodeResult(api.deleteSegment(arguments), EgoiMap.class);
		} catch (RemoteException e) {
			throw new EgoiException(e.getMessage(), e);
		}
	}

	@Override
	public EgoiMap editCampaignEmail(EgoiMap arguments) throws EgoiException {
		try {
			return decodeResult(api.editCampaignEmail(arguments), EgoiMap.class);
		} catch (RemoteException e) {
			throw new EgoiException(e.getMessage(), e);
		}
	}

	@Override
	public EgoiMap editCampaignSMS(EgoiMap arguments) throws EgoiException {
		try {
			return decodeResult(api.editCampaignSMS(arguments), EgoiMap.class);
		} catch (RemoteException e) {
			throw new EgoiException(e.getMessage(), e);
		}
	}

	@Override
	public EgoiMap editExtraField(EgoiMap arguments) throws EgoiException {
		try {
			return decodeResult(api.editExtraField(arguments), EgoiMap.class);
		} catch (RemoteException e) {
			throw new EgoiException(e.getMessage(), e);
		}
	}

	@Override
	public EgoiMap editSubscriber(EgoiMap arguments) throws EgoiException {
		try {
			return decodeResult(api.editSubscriber(arguments), EgoiMap.class);
		} catch (RemoteException e) {
			throw new EgoiException(e.getMessage(), e);
		}
	}

	@Override
	public EgoiMapList getCampaigns(EgoiMap arguments) throws EgoiException {
		try {
			return decodeResult(api.getCampaigns(arguments), EgoiMapList.class);
		} catch (RemoteException e) {
			throw new EgoiException(e.getMessage(), e);
		}
	}

	@Override
	public EgoiMap getClientData(EgoiMap arguments) throws EgoiException {
		try {
			return decodeResult(api.getClientData(arguments), EgoiMap.class);
		} catch (RemoteException e) {
			throw new EgoiException(e.getMessage(), e);
		}
	}

	@Override
	public EgoiMap getCredits(EgoiMap arguments) throws EgoiException {
		try {
			return decodeResult(api.getCredits(arguments), EgoiMap.class);
		} catch (RemoteException e) {
			throw new EgoiException(e.getMessage(), e);
		}
	}

	@Override
	public EgoiMap getReport(EgoiMap arguments) throws EgoiException {
		try {
			return decodeResult(api.getReport(arguments), EgoiMap.class);
		} catch (RemoteException e) {
			throw new EgoiException(e.getMessage(), e);
		}
	}

	@Override
	public EgoiMapList getSegments(EgoiMap arguments) throws EgoiException {
		try {
			return decodeResult(api.getSegments(arguments), EgoiMapList.class);
		} catch (RemoteException e) {
			throw new EgoiException(e.getMessage(), e);
		}
	}

	@Override
	public EgoiMapList getSenders(EgoiMap arguments) throws EgoiException {
		try {
			return decodeResult(api.getSenders(arguments), EgoiMapList.class);
		} catch (RemoteException e) {
			throw new EgoiException(e.getMessage(), e);
		}
	}

	@Override
	public EgoiMap removeSubscriber(EgoiMap arguments) throws EgoiException {
		try {
			return decodeResult(api.removeSubscriber(arguments), EgoiMap.class);
		} catch (RemoteException e) {
			throw new EgoiException(e.getMessage(), e);
		}
	}

	@Override
	public EgoiMap sendCall(EgoiMap arguments) throws EgoiException {
		try {
			return decodeResult(api.sendCall(arguments), EgoiMap.class);
		} catch (RemoteException e) {
			throw new EgoiException(e.getMessage(), e);
		}
	}

	@Override
	public EgoiMap sendEmail(EgoiMap arguments) throws EgoiException {
		try {
			return decodeResult(api.sendEmail(arguments), EgoiMap.class);
		} catch (RemoteException e) {
			throw new EgoiException(e.getMessage(), e);
		}
	}

	@Override
	public EgoiMap sendFAX(EgoiMap arguments) throws EgoiException {
		try {
			return decodeResult(api.sendFAX(arguments), EgoiMap.class);
		} catch (RemoteException e) {
			throw new EgoiException(e.getMessage(), e);
		}
	}

	@Override
	public EgoiMap sendSMS(EgoiMap arguments) throws EgoiException {
		try {
			return decodeResult(api.sendSMS(arguments), EgoiMap.class);
		} catch (RemoteException e) {
			throw new EgoiException(e.getMessage(), e);
		}
	}

	@Override
	public EgoiMap subscriberData(EgoiMap arguments) throws EgoiException {
		try {
			return decodeResult(api.subscriberData(arguments), EgoiMap.class);
		} catch (RemoteException e) {
			throw new EgoiException(e.getMessage(), e);
		}
	}

	@Override
	public EgoiMap updateList(EgoiMap arguments) throws EgoiException {
		try {
			return decodeResult(api.updateList(arguments), EgoiMap.class);
		} catch (RemoteException e) {
			throw new EgoiException(e.getMessage(), e);
		}
	}

        //NEW STUFF
    @Override
    public EgoiMapList getAutobots(EgoiMap arguments) throws EgoiException {
        try {return decodeResult(api.getAutobots(arguments), EgoiMapList.class);} catch (RemoteException e) {throw new EgoiException(e.getMessage(), e);}
    }

    @Override
    public EgoiMap startAutobot(EgoiMap arguments) throws EgoiException {
        try {return decodeResult(api.startAutobot(arguments), EgoiMap.class);} catch (RemoteException e) {throw new EgoiException(e.getMessage(), e);}
    }

    @Override
    public EgoiMap createCampaignGroup(EgoiMap arguments) throws EgoiException {
        try {return decodeResult(api.createCampaignGroup(arguments), EgoiMap.class);} catch (RemoteException e) {throw new EgoiException(e.getMessage(), e);}
    }

    @Override
    public EgoiMap editCampaignGroup(EgoiMap arguments) throws EgoiException {
        try {return decodeResult(api.editCampaignGroup(arguments), EgoiMap.class);} catch (RemoteException e) {throw new EgoiException(e.getMessage(), e);}
    }

    @Override
    public EgoiMapList getHeaderFooterTemplates(EgoiMap arguments) throws EgoiException {
        try {return decodeResult(api.getHeaderFooterTemplates(arguments), EgoiMapList.class);} catch (RemoteException e) {throw new EgoiException(e.getMessage(), e);}
    }

    @Override
    public EgoiMapList getTemplates(EgoiMap arguments) throws EgoiException {
        try {return decodeResult(api.getTemplates(arguments), EgoiMapList.class);} catch (RemoteException e) {throw new EgoiException(e.getMessage(), e);}
    }

    @Override
    public EgoiMap editApiCallback(EgoiMap arguments) throws EgoiException {
        try {return decodeResult(api.editApiCallback(arguments), EgoiMap.class);} catch (RemoteException e) {throw new EgoiException(e.getMessage(), e);}
    }

    @Override
    public EgoiMapList getOperationsQueue(EgoiMap arguments) throws EgoiException {
        try {return decodeResult(api.getOperationsQueue(arguments), EgoiMapList.class);} catch (RemoteException e) {throw new EgoiException(e.getMessage(), e);}
    }

    @Override
    public EgoiMapList getForms(EgoiMap arguments) throws EgoiException {
        try {return decodeResult(api.getForms(arguments), EgoiMapList.class);} catch (RemoteException e) {throw new EgoiException(e.getMessage(), e);}
    }

    @Override
    public EgoiMapList getFormsSubmissions(EgoiMap arguments) throws EgoiException {
        try {return decodeResult(api.getFormsSubmissions(arguments), EgoiMapList.class);} catch (RemoteException e) {throw new EgoiException(e.getMessage(), e);}
    }

    @Override
    public EgoiMap deleteExtraField(EgoiMap arguments) throws EgoiException {
        try {return decodeResult(api.deleteExtraField(arguments), EgoiMap.class);} catch (RemoteException e) {throw new EgoiException(e.getMessage(), e);}
    }

    @Override
    public EgoiMapList getExtraFields(EgoiMap arguments) throws EgoiException {
        try {return decodeResult(api.getExtraFields(arguments), EgoiMapList.class);} catch (RemoteException e) {throw new EgoiException(e.getMessage(), e);}
    }

    @Override
    public EgoiMap generateAdvancedReport(EgoiMap arguments) throws EgoiException {
        try {return decodeResult(api.generateAdvancedReport(arguments), EgoiMap.class);} catch (RemoteException e) {throw new EgoiException(e.getMessage(), e);}
    }

    @Override
    public EgoiMapList getAdvancedReport(EgoiMap arguments) throws EgoiException {
        try {return decodeResult(api.getAdvancedReport(arguments), EgoiMapList.class);} catch (RemoteException e) {throw new EgoiException(e.getMessage(), e);}
    }

    @Override
    public EgoiMap createSegmentAdvanced(EgoiMap arguments) throws EgoiException {
        try {return decodeResult(api.createSegmentAdvanced(arguments), EgoiMap.class);} catch (RemoteException e) {throw new EgoiException(e.getMessage(), e);}
    }

    @Override
    public EgoiMap addCname(EgoiMap arguments) throws EgoiException {
        try {return decodeResult(api.addCname(arguments), EgoiMap.class);} catch (RemoteException e) {throw new EgoiException(e.getMessage(), e);}
    }

    @Override
    public EgoiMap addSender(EgoiMap arguments) throws EgoiException {
        try {return decodeResult(api.addSender(arguments), EgoiMap.class);} catch (RemoteException e) {throw new EgoiException(e.getMessage(), e);}
    }

    @Override
    public EgoiMap deleteSender(EgoiMap arguments) throws EgoiException {
        try {return decodeResult(api.deleteSender(arguments), EgoiMap.class);} catch (RemoteException e) {throw new EgoiException(e.getMessage(), e);}
    }

    @Override
    public EgoiMap editSender(EgoiMap arguments) throws EgoiException {
        try {return decodeResult(api.editSender(arguments), EgoiMap.class);} catch (RemoteException e) {throw new EgoiException(e.getMessage(), e);}
    }

    @Override
    public EgoiMapList getSubscriberActivity(EgoiMap arguments) throws EgoiException {
        try {return decodeResult(api.getSubscriberActivity(arguments), EgoiMapList.class);} catch (RemoteException e) {throw new EgoiException(e.getMessage(), e);}
    }

    @Override
    public EgoiMap addTag(EgoiMap arguments) throws EgoiException {
        try {return decodeResult(api.addTag(arguments), EgoiMap.class);} catch (RemoteException e) {throw new EgoiException(e.getMessage(), e);}
    }

    @Override
    public EgoiMap attachTag(EgoiMap arguments) throws EgoiException {
        try {return decodeResult(api.attachTag(arguments), EgoiMap.class);} catch (RemoteException e) {throw new EgoiException(e.getMessage(), e);}
    }

    @Override
    public EgoiMap deleteTag(EgoiMap arguments) throws EgoiException {
        try {return decodeResult(api.deleteTag(arguments), EgoiMap.class);} catch (RemoteException e) {throw new EgoiException(e.getMessage(), e);}
    }

    @Override
    public EgoiMap detachTag(EgoiMap arguments) throws EgoiException {
        try {return decodeResult(api.detachTag(arguments), EgoiMap.class);} catch (RemoteException e) {throw new EgoiException(e.getMessage(), e);}
    }

    @Override
    public EgoiMapList getTags(EgoiMap arguments) throws EgoiException {
        try {return decodeResult(api.getTags(arguments), EgoiMapList.class);} catch (RemoteException e) {throw new EgoiException(e.getMessage(), e);}
    }

}
