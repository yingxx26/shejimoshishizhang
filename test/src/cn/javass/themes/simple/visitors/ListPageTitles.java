package cn.javass.themes.simple.visitors;

import cn.javass.xgen.genconf.GenConfFactory;
import cn.javass.xgen.genconf.vo.ModuleConfModel;
import cn.javass.xgen.template.visitor.TemplateElement;
import cn.javass.xgen.template.visitor.Visitor;

public class ListPageTitles implements Visitor {

	@Override
	public Object visitTemplateElement(TemplateElement element) {
		ModuleConfModel moduleConf = element.getModuleConf();
		
		String [] colunName_CN = moduleConf.getMapExtends().get( "colunName_CN").getValues();	
		StringBuffer buffer = new StringBuffer("");
		for(String s : colunName_CN){
			buffer.append("<td align='center'  class='tableLineBge'>"+s+"</td>\n\t");
		}
		return buffer.toString();
	}

}