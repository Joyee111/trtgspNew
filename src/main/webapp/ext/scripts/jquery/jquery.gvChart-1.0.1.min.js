/*
 * jQuery gvChart plugin
 * This plugin was created to simplify things when using Google Visualisation Charts. 
 * It still needs to be used with google script import tag, however now you can
 * crate chart from your table. 
 * All examples you will find on http://www.ivellios.toron.pl/technikalia/demos/gvChart/
 * @name jquery.gvChart-1.0.1.min.js
 * @author Janusz 
 * @version 1.0.1
 * @date December 04, 2010
 * @category jQuery plugin google charts
 * @copyright (c) 2010 Janusz Kamie
 * @license CC Attribution Works 3.0 Poland - http://creativecommons.org/licenses/by/3.0/pl/deed.en_US
 * @example Visit http://www.ivellios.toron.pl/technikalia/demos/gvChart/ for more informations about this jQuery plugin
 */
(function(jQuery) {
	jQuery.fn.gvChart = function(settings) {
		defaults = {
			hideTable : true,
			chartType : 'AreaChart',
			chartDivID : 'gvChartDiv',
			gvSettings : null
		};
		var el = document.createElement('div');
		jQuery(el).insertBefore(this);
		gvChartCount++;
		gvChartID = defaults.chartDivID + gvChartCount;
		jQuery(el).attr('id', gvChartID);
		jQuery(el).addClass('gvChart');
		if (settings) {
			jQuery.extend(defaults, settings);
		}
		if (defaults.hideTable)
			jQuery(this).hide();
		var data = new google.visualization.DataTable();
		data.addColumn('string', 'X labels');
		var a = new Array();
		var headers = jQuery(this).find('thead').find('th');
		var rows = jQuery(this).find('tbody').find('tr');
		rows.each(function(index) {
			data.addColumn('number', jQuery(this).find('th').text());
		});
		data.addRows(headers.length - 1);
		headers.each(function(index) {
			if (index) {
				data.setCell(index - 1, 0, jQuery(this).text());
			}
		});
		rows.each(function(index) {
			jQuery(this).find('td').each(function(index2) {
				data.setCell(index2, index + 1, parseFloat(jQuery(this).text()));
			});
		});
		chartSettings = {
			title : jQuery(this).find('caption').text()
		};
		if (defaults.gvSettings) {
			jQuery.extend(chartSettings, defaults.gvSettings);
		}
		eval("var chart = new google.visualization." + defaults.chartType
				+ "(document.getElementById('" + gvChartID + "'))");
		chart.draw(data, chartSettings);
	}
})(jQuery);
function gvChartInit() {
	gvChartCount = 0;
	google.load('visualization', '1', {
		packages : [ 'corechart' ]
	});
}
