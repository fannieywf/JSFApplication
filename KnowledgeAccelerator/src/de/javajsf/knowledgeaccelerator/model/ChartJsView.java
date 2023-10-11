package de.javajsf.knowledgeaccelerator.model;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.line.LineChartDataSet;
import org.primefaces.model.charts.line.LineChartOptions;
import org.primefaces.model.charts.optionconfig.title.Title;
import org.primefaces.model.charts.scatter.ScatterChartModel;

import de.javajsf.knowledgeaccelerator.service.DataService;

@ManagedBean
@RequestScoped
public class ChartJsView implements Serializable {
	
	private ScatterChartModel scatterModel;
	
	@PostConstruct
	public void init() {
		System.out.println("init createScatterModel...");
		createScatterModel();
	}
	
	public ScatterChartModel getScatterModel() {
		return scatterModel;
	}

	public void setScatterModel(ScatterChartModel scatterModel) {
		this.scatterModel = scatterModel;
	}

	public void createScatterModel() {
		System.out.println("createScatterModel...");
		scatterModel = new ScatterChartModel();
		ChartData data = new ChartData();
		LineChartDataSet dataSet = new LineChartDataSet();
		
		List<Object> pts = DataService.createList();

		System.out.println("Points after adding Points to pts: " + pts);
		
		dataSet.setData(pts); 
		dataSet.setLabel("Red Dataset");
		dataSet.setBorderColor("rgb(249, 24, 24)");
		dataSet.setShowLine(false);
		data.addChartDataSet(dataSet);
		
        LineChartOptions options = new LineChartOptions();        
        Title title = new Title();
        title.setDisplay(true);
        title.setText("Scatter Chart by User Input");
        options.setShowLines(false);
        options.setTitle(title);
         
        scatterModel.setOptions(options);
		
		scatterModel.setData(data);
		System.out.println("data set to scatterModel...finished!");
	}

	
	public static void main(String[] args) {
		System.out.println("Running ChartJsView...");
		ChartJsView cjv = new ChartJsView();
		cjv.init();
	}
	
}
