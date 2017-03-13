package similarity;
//
//Source code recreated from a .class file by IntelliJ IDEA
//(powered by Fernflower decompiler)
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RefineryUtilities;

public class XYplot {
 public XYplot() {
 }

 public static void plot(Integer[] pattern, ArrayList<List<Integer>> patterns) {
     StandardChartTheme mChartTheme = new StandardChartTheme("CN");
     mChartTheme.setLargeFont(new Font("黑体", 1, 20));
     mChartTheme.setExtraLargeFont(new Font("宋体", 0, 15));
     mChartTheme.setRegularFont(new Font("宋体", 0, 15));
     ChartFactory.setChartTheme(mChartTheme);
     XYSeriesCollection dataset = getCollection(pattern, patterns);
     JFreeChart chart = ChartFactory.createXYLineChart("匹配结果", "", "Y", dataset, PlotOrientation.VERTICAL, true, true, false);
     XYPlot plot = (XYPlot)chart.getPlot();
     XYLineAndShapeRenderer xylineandshaperenderer = (XYLineAndShapeRenderer)plot.getRenderer();
     ValueAxis valueaxis = plot.getRangeAxis();
     valueaxis.setAutoRangeMinimumSize(15.0D);
     valueaxis.setLowerBound(0.0D);
     valueaxis.setUpperBound(90.0D);
     xylineandshaperenderer.setBaseShapesVisible(true);
     XYItemRenderer xyitem = plot.getRenderer();
     xyitem.setBaseItemLabelsVisible(true);

     try {
         ChartFrame e = new ChartFrame("", chart);
         e.pack();
         RefineryUtilities.centerFrameOnScreen(e);
         e.setVisible(true);
     } catch (Exception var10) {
         System.err.println("Problem occurred creating chart.");
     }

 }

 public static XYSeriesCollection getCollection(Integer[] pattern, ArrayList<List<Integer>> patternlist) {
     XYSeriesCollection collection = new XYSeriesCollection();
     XYSeries[] xySeries = new XYSeries[patternlist.size()];

     for(int ts = 0; ts < xySeries.length; ++ts) {
         xySeries[ts] = new XYSeries("similarity pattern" + (ts + 1) + "--相似度" + Query.similarityList.get(ts));
     }

     new TimeSeries("1");
     XYSeries patternSeries = new XYSeries("pattern");

     int i;
     for(i = 0; i < pattern.length; ++i) {
         patternSeries.add((double)i, pattern[i]);
     }

     collection.addSeries(patternSeries);

     for(i = 0; i < patternlist.size(); ++i) {
         for(int j = 0; j <patternlist.get(i).size(); ++j) {
             xySeries[i].add((double)j, patternlist.get(i).get(j)+i);
         }

         collection.addSeries(xySeries[i]);
     }

     return collection;
 }
}
