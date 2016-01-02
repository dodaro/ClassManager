/**
 * 
 */
package it.unical.classmanager.statistics.queryCart.student;

import java.util.List;

import it.unical.classmanager.model.dao.CartQueryDAO;
import it.unical.classmanager.model.dao.DaoHelper;
import it.unical.classmanager.model.data.Student;
import it.unical.classmanager.model.data.User;
import it.unical.classmanager.statistics.cart.AbstractCart;
import it.unical.classmanager.statistics.cart.ColumnDrilldownCart;
import it.unical.classmanager.statistics.queryCart.AbstractQueryCart;

/**
 * @author Aloisius92
 * Query: "Per ogni corso la media delle presenze"
 */
public class Student_AvgAttendance extends AbstractQueryCart {
    
    public Student_AvgAttendance() {
	super();
    }
    
    public Student_AvgAttendance(User user){
	super(user);
    }
    
    /* (non-Javadoc)
     * @see it.unical.classmanager.statistics.queryCart.AbstractQueryCart#buildCartFromQuery()
     */
    @Override
    protected AbstractCart buildCartFromQuery() {
	return buildCartFromQuery(new ColumnDrilldownCart());
    }
    
    @Override
    protected AbstractCart buildCartFromQuery(AbstractCart cart) {
	// Query
	CartQueryDAO cartQueryDAO = DaoHelper.getCartQueryDAO();
	List<Object[]> avgAttendanceByStudent = cartQueryDAO.getAvgAttendanceByStudent((Student)this.getUser());
	/*
	 * avgAttendanceByStudent
	 * CourseName1, Avg1
	 * CourseName2, Avg2
	 * CourseName3, Avg3
	 * ...
	 * CourseNameN, AvgN
	 */	
	
	cart.setTitle("Media delle presenze");
	cart.setSubTitle("Per ogni corso ");
	cart.setxAxisTitle("Corsi");
	StringBuilder seriesContent = new StringBuilder("");
	seriesContent.append("{");
	{
	    seriesContent.append("\n");
	    seriesContent.append("name: \'Brands\',\n");
	    seriesContent.append("colorByPoint: true,\n");
	    seriesContent.append("data: [");
	    
	    if(avgAttendanceByStudent.size()>0){
		String name = avgAttendanceByStudent.get(0)[0].toString();
		float value = Float.parseFloat(avgAttendanceByStudent.get(0)[1].toString());
		seriesContent.append("{ name: \'"+name+"\',\n");
		seriesContent.append("y: "+value+",\n");
		seriesContent.append("drilldown: null}\n");
		
		for(int i=1; i<avgAttendanceByStudent.size(); i++){
		    name = avgAttendanceByStudent.get(i)[0].toString();
		    value = Float.parseFloat(avgAttendanceByStudent.get(i)[1].toString());
		    seriesContent.append(", { name: \'"+name+"\',\n");
		    seriesContent.append("y: "+value+",\n");
		    seriesContent.append("drilldown: null}\n");
		}
	    }
	    seriesContent.append("]\n");
	    seriesContent.append("}");
	}
	cart.setSeriesContent(seriesContent);
	
	StringBuilder drilldownContent = new StringBuilder("");
	drilldownContent.append("{}");
	//	drilldownContent.append("{");
	//	{
	//	    drilldownContent.append("\n");
	//	    drilldownContent.append("name: \'Microsoft Internet Explorer\',\n");
	//	    drilldownContent.append("id: \'Microsoft Internet Explorer\',\n");
	//	    drilldownContent.append("data: [\n");
	//	    drilldownContent.append("[\n");
	//	    drilldownContent.append("\'v11.0\',\n");
	//	    drilldownContent.append("24.13\n");
	//	    drilldownContent.append("],\n");
	//	    drilldownContent.append("[\n");
	//	    drilldownContent.append("\'v8.0\',\n");
	//	    drilldownContent.append("17.2\n");
	//	    drilldownContent.append("],\n");
	//	    drilldownContent.append("[\n");
	//	    drilldownContent.append("\'v9.0\',\n");
	//	    drilldownContent.append("8.11\n");
	//	    drilldownContent.append("],\n");
	//	    drilldownContent.append("[\n");
	//	    drilldownContent.append("\'v10.0\',\n");
	//	    drilldownContent.append("5.33\n");
	//	    drilldownContent.append("],\n");
	//	    drilldownContent.append("[\n");
	//	    drilldownContent.append("\'v6.0\',\n");
	//	    drilldownContent.append("1.06\n");
	//	    drilldownContent.append("],\n");
	//	    drilldownContent.append("[\n");
	//	    drilldownContent.append("\'v7.0\',\n");
	//	    drilldownContent.append("0.5\n");
	//	    drilldownContent.append("]\n");
	//	    drilldownContent.append("]\n");
	//	    drilldownContent.append("}");
	//	}
	//	drilldownContent.append(", {");
	//	{
	//	    drilldownContent.append("\n");
	//	    drilldownContent.append("name: \'Chrome\',\n");
	//	    drilldownContent.append("id: \'Chrome\',\n");
	//	    drilldownContent.append("data: [\n");
	//	    drilldownContent.append("[\n");
	//	    drilldownContent.append("\'v40.0\',\n");
	//	    drilldownContent.append("5\n");
	//	    drilldownContent.append("],\n");
	//	    drilldownContent.append("[\n");
	//	    drilldownContent.append("\'v41.0\',\n");
	//	    drilldownContent.append("4.32\n");
	//	    drilldownContent.append("],\n");
	//	    drilldownContent.append("[\n");
	//	    drilldownContent.append("\'v42.0\',\n");
	//	    drilldownContent.append("3.68\n");
	//	    drilldownContent.append("],\n");
	//	    drilldownContent.append("[\n");
	//	    drilldownContent.append("\'v39.0\',\n");
	//	    drilldownContent.append("2.96\n");
	//	    drilldownContent.append("],\n");
	//	    drilldownContent.append("[\n");
	//	    drilldownContent.append("\'v36.0\',\n");
	//	    drilldownContent.append("2.53\n");
	//	    drilldownContent.append("],\n");
	//	    drilldownContent.append("[\n");
	//	    drilldownContent.append("\'v43.0\',\n");
	//	    drilldownContent.append("1.45\n");
	//	    drilldownContent.append("],\n");
	//	    drilldownContent.append("[\n");
	//	    drilldownContent.append("\'v31.0\',\n");
	//	    drilldownContent.append("1.24\n");
	//	    drilldownContent.append("],\n");
	//	    drilldownContent.append("[\n");
	//	    drilldownContent.append("\'v35.0\',\n");
	//	    drilldownContent.append("0.85\n");
	//	    drilldownContent.append("],\n");
	//	    drilldownContent.append("[\n");
	//	    drilldownContent.append("\'v38.0\',\n");
	//	    drilldownContent.append("0.6\n");
	//	    drilldownContent.append("],\n");
	//	    drilldownContent.append("[\n");
	//	    drilldownContent.append("\'v32.0\',\n");
	//	    drilldownContent.append("0.55\n");
	//	    drilldownContent.append("],\n");
	//	    drilldownContent.append("[\n");
	//	    drilldownContent.append("\'v37.0\',\n");
	//	    drilldownContent.append("0.38\n");
	//	    drilldownContent.append("],\n");
	//	    drilldownContent.append("[\n");
	//	    drilldownContent.append("\'v33.0\',\n");
	//	    drilldownContent.append("0.19\n");
	//	    drilldownContent.append("],\n");
	//	    drilldownContent.append("[\n");
	//	    drilldownContent.append("\'v34.0\',\n");
	//	    drilldownContent.append("0.14\n");
	//	    drilldownContent.append("],\n");
	//	    drilldownContent.append("[\n");
	//	    drilldownContent.append("\'v30.0\',\n");
	//	    drilldownContent.append("0.14\n");
	//	    drilldownContent.append("]\n");
	//	    drilldownContent.append("]\n");
	//	    drilldownContent.append("}");
	//	}
	//	drilldownContent.append(", {");
	//	{
	//	    drilldownContent.append("\n");
	//	    drilldownContent.append("name: \'Firefox\',\n");
	//	    drilldownContent.append("id: \'Firefox\',\n");
	//	    drilldownContent.append("data: [\n");
	//	    drilldownContent.append("[\n");
	//	    drilldownContent.append("\'v35\',\n");
	//	    drilldownContent.append("2.76\n");
	//	    drilldownContent.append("],\n");
	//	    drilldownContent.append("[\n");
	//	    drilldownContent.append("\'v36\',\n");
	//	    drilldownContent.append("2.32\n");
	//	    drilldownContent.append("],\n");
	//	    drilldownContent.append("[\n");
	//	    drilldownContent.append("\'v37\',\n");
	//	    drilldownContent.append("2.31\n");
	//	    drilldownContent.append("],\n");
	//	    drilldownContent.append("[\n");
	//	    drilldownContent.append("\'v34\',\n");
	//	    drilldownContent.append("1.27\n");
	//	    drilldownContent.append("],\n");
	//	    drilldownContent.append("[\n");
	//	    drilldownContent.append("\'v38\',\n");
	//	    drilldownContent.append("1.02\n");
	//	    drilldownContent.append("],\n");
	//	    drilldownContent.append("[\n");
	//	    drilldownContent.append("\'v31\',\n");
	//	    drilldownContent.append("0.33\n");
	//	    drilldownContent.append("],\n");
	//	    drilldownContent.append("[\n");
	//	    drilldownContent.append("\'v33\',\n");
	//	    drilldownContent.append("0.22\n");
	//	    drilldownContent.append("],\n");
	//	    drilldownContent.append("[\n");
	//	    drilldownContent.append("\'v32\',\n");
	//	    drilldownContent.append("0.15\n");
	//	    drilldownContent.append("]\n");
	//	    drilldownContent.append("]\n");
	//	    drilldownContent.append("}");
	//	}
	//	drilldownContent.append(", {");
	//	{
	//	    drilldownContent.append("\n");
	//	    drilldownContent.append("name: \'Safari\',\n");
	//	    drilldownContent.append("id: \'Safari\',\n");
	//	    drilldownContent.append("data: [\n");
	//	    drilldownContent.append("[\n");
	//	    drilldownContent.append("\'v8.0\',\n");
	//	    drilldownContent.append("2.56\n");
	//	    drilldownContent.append("],\n");
	//	    drilldownContent.append("[\n");
	//	    drilldownContent.append("\'v7.1\',\n");
	//	    drilldownContent.append("0.77\n");
	//	    drilldownContent.append("],\n");
	//	    drilldownContent.append("[\n");
	//	    drilldownContent.append("\'v5.1\',\n");
	//	    drilldownContent.append("0.42\n");
	//	    drilldownContent.append("],\n");
	//	    drilldownContent.append("[\n");
	//	    drilldownContent.append("\'v5.0\',\n");
	//	    drilldownContent.append("0.3\n");
	//	    drilldownContent.append("],\n");
	//	    drilldownContent.append("[\n");
	//	    drilldownContent.append("\'v6.1\',\n");
	//	    drilldownContent.append("0.29\n");
	//	    drilldownContent.append("],\n");
	//	    drilldownContent.append("[\n");
	//	    drilldownContent.append("\'v7.0\',\n");
	//	    drilldownContent.append("0.26\n");
	//	    drilldownContent.append("],\n");
	//	    drilldownContent.append("[\n");
	//	    drilldownContent.append("\'v6.2\',\n");
	//	    drilldownContent.append("0.17\n");
	//	    drilldownContent.append("]\n");
	//	    drilldownContent.append("]\n");
	//	    drilldownContent.append("}");
	//	}
	//	drilldownContent.append(", {");
	//	{
	//	    drilldownContent.append("\n");
	//	    drilldownContent.append("name: \'Opera\',\n");
	//	    drilldownContent.append("id: \'Opera\',\n");
	//	    drilldownContent.append("data: [\n");
	//	    drilldownContent.append("[\n");
	//	    drilldownContent.append("\'v12.x\',\n");
	//	    drilldownContent.append("0.34\n");
	//	    drilldownContent.append("],\n");
	//	    drilldownContent.append("[\n");
	//	    drilldownContent.append("\'v28\',\n");
	//	    drilldownContent.append("0.24\n");
	//	    drilldownContent.append("],\n");
	//	    drilldownContent.append("[\n");
	//	    drilldownContent.append("\'v27\',\n");
	//	    drilldownContent.append("0.17\n");
	//	    drilldownContent.append("],\n");
	//	    drilldownContent.append("[\n");
	//	    drilldownContent.append("\'v29\',\n");
	//	    drilldownContent.append("0.16\n");
	//	    drilldownContent.append("]\n");
	//	    drilldownContent.append("]\n");
	//	    drilldownContent.append("}");
	//	}
	cart.setDrilldownContent(drilldownContent);
	
	return cart;
    }
    
}
