package cn.javass.themes.mytheme.outtype;

import java.util.Observable;

import cn.javass.xgen.genconf.vo.ModuleConfModel;
import cn.javass.xgen.geninvocation.DefaultGenInvocation;
import cn.javass.xgen.output.GenOutputEbi;
import cn.javass.xgen.template.TemplateEbi;

public class MyOutput implements GenOutputEbi{

	private void output(ModuleConfModel moduleConf, String genTypeId,
			String content) {
		System.out.println("my db========="+content);
	}

	@Override
	public void update(Observable o, Object content) {
		DefaultGenInvocation invok = (DefaultGenInvocation)o;
		String contentStr = (String)((TemplateEbi)content).getNowContent();
		this.output(invok.getModuleConf(), invok.getCmd(), contentStr);
	}
}
