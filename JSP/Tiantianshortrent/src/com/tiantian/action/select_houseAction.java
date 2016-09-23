package com.tiantian.action;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tiantian.dao.impl.jdbcDao;

public class select_houseAction extends ActionSupport {

	private String location_search;
	private String detail_search;
	private String ruzu_date;
	private String tuifang_date;

	private String lowest;
	private String highest;
	private String lowestarea;
	private String highestarea;

	public String getLowest() {
		return lowest;
	}

	public void setLowest(String lowest) {
		this.lowest = lowest;
	}

	public String getHighest() {
		return highest;
	}

	public void setHighest(String highest) {
		this.highest = highest;
	}

	public String getLowestarea() {
		return lowestarea;
	}

	public void setLowestarea(String lowestarea) {
		this.lowestarea = lowestarea;
	}

	public String getHighestarea() {
		return highestarea;
	}

	public void setHighestarea(String highestarea) {
		this.highestarea = highestarea;
	}

	public String getLocation_search() {
		return location_search;
	}

	public void setLocation_search(String location_search) {
		this.location_search = location_search;
	}

	public String getDetail_search() {
		return detail_search;
	}

	public void setDetail_search(String detail_search) {
		this.detail_search = detail_search;
	}

	public String getRuzu_date() {
		return ruzu_date;
	}

	public void setRuzu_date(String ruzu_date) {
		this.ruzu_date = ruzu_date;
	}

	public String getTuifang_date() {
		return tuifang_date;
	}

	public void setTuifang_date(String tuifang_date) {
		this.tuifang_date = tuifang_date;
	}

	public String select_house() {

		System.out.println(location_search);
		System.out.println(detail_search);
		System.out.println(ruzu_date);
		System.out.println(tuifang_date);

		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();

		jdbcDao dao = new jdbcDao("tiantian");
		ResultSet rs = dao
				.select_house("select * from house where Rent_station=1  ");

		JsonArray ja = new JsonArray();
		int i = 0;
		if (detail_search == null) {
			detail_search = "";
		}
		if (location_search == null) {
			location_search = "";
		}

		double lowest_data = 0;
		double highest_data = 1000000;
		double lowestarea_data = 0;
		double highestarea_data = 1000000;

		if (lowest.equals("")) {
			lowest_data = 0;
		} else {
			lowest_data = Double.parseDouble(lowest);
		}
		if (highest.equals("")) {
			highest_data = 100000000;
		} else {
			highest_data = Double.parseDouble(highest);
		}
		if (lowestarea.equals("")) {
			lowestarea_data = 0;
		} else {
			lowestarea_data = Double.parseDouble(lowestarea);
		}
		if (highestarea.equals("")) {
			highestarea_data = 100000000;
		} else {
			highestarea_data = Double.parseDouble(highestarea);
		}

		try {
			while (rs.next()) {

				JsonObject o = new JsonObject();
				if ((detail_search.contains(rs.getString("Name").toString()
						.replace("\"", "")) || rs.getString("Name").toString()
						.replace("\"", "").contains(detail_search))
						&& (location_search.contains(rs.getString("Address")
								.toString().replace("\"", "")) || rs
								.getString("Address").toString()
								.replace("\"", "").contains(location_search))
						&& (rs.getDouble("Price") >= lowest_data && rs
								.getDouble("Price") <= highest_data)
						&& (rs.getDouble("Area") >= lowestarea_data && rs
								.getDouble("Area") <= highestarea_data)) {
					o.addProperty("Master" + i, rs.getString("Master"));
					o.addProperty("House_id" + i, rs.getString("House_id"));
					o.addProperty("Address" + i, rs.getString("Address"));
					o.addProperty("Rent_station" + i,
							rs.getString("Rent_station"));
					o.addProperty("Price" + i, rs.getString("Price"));
					o.addProperty("Area" + i, rs.getString("Area"));
					o.addProperty("Surrounding" + i,
							rs.getString("Surrounding"));
					o.addProperty("Others" + i, rs.getString("Others"));
					o.addProperty("Name" + i, rs.getString("Name"));
					o.addProperty("Src" + i, rs.getString("Src"));

					ja.add(o);
					i++;
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(ja.toString());
		session.put("select_house_list", ja.toString());

		return "success";
	}
}
