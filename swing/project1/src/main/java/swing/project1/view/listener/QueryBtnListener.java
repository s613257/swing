package swing.project1.view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import swing.project1.db.dao.AdoptionInfoDAO;
import swing.project1.db.dao.impl.AdoptionInfoDAOImpl;
import swing.project1.model.QueryCondition;
import swing.project1.view.MainFrame;

public class QueryBtnListener implements ActionListener {
	private MainFrame parent;

	public QueryBtnListener(MainFrame parent) {
		this.parent = parent;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		AdoptionInfoDAO aid = new AdoptionInfoDAOImpl();
		QueryCondition qc = parent.getQueryCondition();
		parent.showQueryResult(aid.getInfoByCondition(qc));
	}
}
