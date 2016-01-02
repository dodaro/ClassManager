package it.unical.classmanager.controllers;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.unical.classmanager.statistics.CartsList;
import it.unical.classmanager.statistics.cart.AbstractCart;
import it.unical.classmanager.statistics.cart.AreaStackedCart;
import it.unical.classmanager.statistics.cart.Bubble3DCart;
import it.unical.classmanager.statistics.cart.BubbleCart;
import it.unical.classmanager.statistics.cart.ColumnBasicCart;
import it.unical.classmanager.statistics.cart.ColumnDrilldownCart;
import it.unical.classmanager.statistics.cart.ColumnNullValues3DCart;
import it.unical.classmanager.statistics.cart.ColumnStackedAndGroupedCart;
import it.unical.classmanager.statistics.cart.ColumnStackedCart;
import it.unical.classmanager.statistics.cart.ColumnStackedPercentCart;
import it.unical.classmanager.statistics.cart.ColumnStackingGrouping3DCart;
import it.unical.classmanager.statistics.cart.LineBasicCart;
import it.unical.classmanager.statistics.cart.Pie3DCart;
import it.unical.classmanager.statistics.cart.PieBasicCart;
import it.unical.classmanager.statistics.cart.PieDonut3DCart;
import it.unical.classmanager.statistics.cart.PieDonutCart;
import it.unical.classmanager.statistics.cart.PieDrilldownCart;
import it.unical.classmanager.statistics.cart.PieGradientCart;
import it.unical.classmanager.statistics.cart.PieLegendCart;
import it.unical.classmanager.statistics.cart.PieMonochromeCart;
import it.unical.classmanager.statistics.cart.PieSemiCircleCart;
import it.unical.classmanager.statistics.cart.PolarCart;
import it.unical.classmanager.statistics.cart.PolarSpiderCart;
import it.unical.classmanager.statistics.cart.SplineIrregularTimeCart;
import it.unical.classmanager.statistics.cart.notSelected.AreaBasicCart;
import it.unical.classmanager.statistics.cart.notSelected.AreaInvertedCart;
import it.unical.classmanager.statistics.cart.notSelected.AreaMissingCart;
import it.unical.classmanager.statistics.cart.notSelected.AreaNegativeCart;
import it.unical.classmanager.statistics.cart.notSelected.AreaRangeCart;
import it.unical.classmanager.statistics.cart.notSelected.AreaRangeLineCart;
import it.unical.classmanager.statistics.cart.notSelected.AreaSplineCart;
import it.unical.classmanager.statistics.cart.notSelected.AreaStackedPercentCart;
import it.unical.classmanager.statistics.cart.notSelected.BarBasicCart;
import it.unical.classmanager.statistics.cart.notSelected.BarNegativeStackCart;
import it.unical.classmanager.statistics.cart.notSelected.BarStackedCart;
import it.unical.classmanager.statistics.cart.notSelected.BoxPlotCart;
import it.unical.classmanager.statistics.cart.notSelected.ColumnNegativeCart;
import it.unical.classmanager.statistics.cart.notSelected.ColumnPlacementCart;
import it.unical.classmanager.statistics.cart.notSelected.ColumnRangeCart;
import it.unical.classmanager.statistics.cart.notSelected.ColumnRotatedLabelsCart;
import it.unical.classmanager.statistics.cart.notSelected.ComboCart;
import it.unical.classmanager.statistics.cart.notSelected.ComboDualAxesCart;
import it.unical.classmanager.statistics.cart.notSelected.ComboMultiAxesCart;
import it.unical.classmanager.statistics.cart.notSelected.ComboRegressionCart;
import it.unical.classmanager.statistics.cart.notSelected.DynamicClickToAddCart;
import it.unical.classmanager.statistics.cart.notSelected.ErrorBarCart;
import it.unical.classmanager.statistics.cart.notSelected.GaugeClockCart;
import it.unical.classmanager.statistics.cart.notSelected.GaugeDualCart;
import it.unical.classmanager.statistics.cart.notSelected.GaugeSpeedometerCart;
import it.unical.classmanager.statistics.cart.notSelected.GaugeVuMeterCart;
import it.unical.classmanager.statistics.cart.notSelected.LineAjaxCart;
import it.unical.classmanager.statistics.cart.notSelected.LineLabelsCart;
import it.unical.classmanager.statistics.cart.notSelected.LineLogAxisCart;
import it.unical.classmanager.statistics.cart.notSelected.LineTimeSeriesCart;
import it.unical.classmanager.statistics.cart.notSelected.PolygonCart;
import it.unical.classmanager.statistics.cart.notSelected.SplineInvertedCart;
import it.unical.classmanager.statistics.cart.notSelected.SplinePlotBandsCart;
import it.unical.classmanager.statistics.cart.notSelected.SplineSymbolsCart;
import it.unical.classmanager.statistics.cart.notSelected.WaterfallCart;

/**
 * @author Aloisius92
 * Handles requests for the all carts page.
 * This is just for developing reasons!
 */
@Controller
public class AllCartsController {

    private static final Logger logger = LoggerFactory.getLogger(AllCartsController.class);

    @Autowired
    ApplicationContext appContext;

    /**
     * Show all available carts.
     */
    @RequestMapping(value = "/allCarts", method = RequestMethod.GET)
    public String statistics(Locale locale, Model model,HttpServletRequest request) {
	logger.info("All cart Page", locale);

	AbstractCart[] cartsArray = {
		new AreaBasicCart(),
		new AreaInvertedCart(),
		new AreaMissingCart(),
		new AreaNegativeCart(),
		new AreaRangeCart(),
		new AreaRangeLineCart(),
		new AreaSplineCart(),
		new AreaStackedCart(),
		new AreaStackedPercentCart(),
		new BarBasicCart(),
		new BarNegativeStackCart(),
		new BarStackedCart(),
		new BoxPlotCart(),
		new BubbleCart(),
		new Bubble3DCart(),
		new ColumnBasicCart(),
		new ColumnDrilldownCart(),
		new ColumnNegativeCart(),
		new ColumnNullValues3DCart(),
		new SplineSymbolsCart(),
		new SplineInvertedCart(),
		new SplineIrregularTimeCart(),
		new SplinePlotBandsCart(),
		new PolygonCart(),
		new PieMonochromeCart(),
		new PieSemiCircleCart(),
		new PolarCart(),
		new PolarSpiderCart(),
		new PieDrilldownCart(),
		new PieGradientCart(),
		new PieLegendCart(),
		new Pie3DCart(),
		new PieBasicCart(),
		new PieDonutCart(),
		new PieDonut3DCart(),
		new LineAjaxCart(),
		new LineBasicCart(),
		new LineLabelsCart(),
		new LineLogAxisCart(),
		new LineTimeSeriesCart(),
		new GaugeClockCart(),
		new GaugeDualCart(),
		new GaugeSpeedometerCart(),
		new GaugeVuMeterCart(),
		new DynamicClickToAddCart(),
		new ErrorBarCart(),
		new ComboCart(),
		new ComboDualAxesCart(),
		new ComboMultiAxesCart(),
		new ComboRegressionCart(),
		new ColumnStackedCart(),
		new ColumnStackedAndGroupedCart(),
		new ColumnStackedPercentCart(),
		new ColumnStackingGrouping3DCart(),
		new ColumnPlacementCart(),
		new ColumnRangeCart(),
		new ColumnRotatedLabelsCart(),
		new WaterfallCart(),
		/***********************/
		//Doesn't work!
		/***********************/
//		new ColumnInteractive3DCart(),
//		new ColumnParsedCart(),
//		new ComboMeteogramCart(),
//		new ComboTimelineCart(),
//		new DynamicMasterDetailCart(),
//		new DynamicUpdateCart(),
//		new FunnelCart(),
//		new GaugeSolidCart(),
//		new HeatmapCart(),
//		new HeatmapCanvasCart(),
//		new PolarWindRoseCart(), 
//		new PyramidCart(), 
//		new RendererCart(),
//		new ScatterCart(),
//		new ScatterDraggable3DCart(),
//		new SparklineCart(),
//		new SynchronizedChartsCart(), 
//		new TreemapColoraxisCart(),
//		new TreemapLargeDatasetCart(),
//		new TreemapWithLevelsCart()
	};

	CartsList carts = new CartsList();
	for(int i=1; i<=cartsArray.length; i++){
	    AbstractCart cart = cartsArray[i-1];
	    cart.setIdContainer("container"+i);
	    model.addAttribute("cart"+i, cart);	
	    carts.add(cart);
	}	

	model.addAttribute("cartList", carts);

	return "allCarts";
    }

}
