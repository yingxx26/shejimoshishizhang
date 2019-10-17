package cn.javass.themes.mytheme.decorators;

import cn.javass.xgen.genconf.vo.ModuleConfModel;
import cn.javass.xgen.geninvocation.decorator.GenComponent;
import cn.javass.xgen.geninvocation.decorator.GenDecorator;
import cn.javass.xgen.mediator.CoreMediator;
import cn.javass.xgen.template.TemplateEbi;

public class MyDecorator extends GenDecorator{

	public MyDecorator(GenComponent component) {
		super(component);
	}
	
	@Override
	public Object operation(ModuleConfModel moduleConf, String genTypeId,
			Object obj) {
		//先要获得上一步处理完成的内容
		obj = this.component.operation(moduleConf, genTypeId, obj);
		
		TemplateEbi te = (TemplateEbi)obj;
		
		te.setNowContent("after======="+te.getNowContent());
		
		return te;
	}

}
