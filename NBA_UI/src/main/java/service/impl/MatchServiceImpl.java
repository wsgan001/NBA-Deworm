package service.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import service.MatchService;
import vo.MatchInfoVO;
import vo.MatchPlayerAdvancedVO;
import vo.MatchPlayerBasicVO;


/**
 * MatchService 的具体实现
 * 
 * created by JaneLDQ on 2015年5月31日 下午8:26:38
 */
public class MatchServiceImpl extends UnicastRemoteObject implements MatchService {
	
	private static final long serialVersionUID = 1L;
	
	public MatchServiceImpl() throws RemoteException {
		super();
	}

	public List<MatchInfoVO> getRegularMatchInfoBySeason(String season)
			throws RemoteException {
		return null;
	}

	public List<MatchInfoVO> getPlayOffMatchInfoBySeason(String season) {
		return null;
	}

	public List<MatchInfoVO> getMatchInfoByDate(String begin, String end) {
		return null;
	}

	public List<MatchPlayerAdvancedVO> getMatchPlayerAdvancedByGameIdTeam(
			String gameid, String abbr) {
		return null;
	}

	public List<MatchPlayerBasicVO> getMatchPlayerBasicByGameIdTeam(
			String gameid, String abbr) {
		return null;
	}

}
