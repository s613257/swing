package swing.project1.view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import swing.project1.db.dao.AdoptionInfoDAO;
import swing.project1.db.dao.impl.AdoptionInfoDAOImpl;
import swing.project1.db.dto.AdoptionInfoDTO;
import swing.project1.model.QueryCondition;
import swing.project1.view.MainFrame;

public class QueryBtnListener implements ActionListener {
	private MainFrame parent;

	public QueryBtnListener(MainFrame parent) {
		this.parent = parent;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		List<AdoptionInfoDTO> queryItems = getQueryResult();
		parent.showQueryResult(queryItems);
	}

	private List<AdoptionInfoDTO> getQueryResult() {
		QueryCondition qc = parent.getQueryCondition();
		// TODO
		AdoptionInfoDAO aid = new AdoptionInfoDAOImpl();
		
		List<AdoptionInfoDTO> queryItems = aid.getInfoByCondition(qc);
		
		return queryItems;
	}

}
