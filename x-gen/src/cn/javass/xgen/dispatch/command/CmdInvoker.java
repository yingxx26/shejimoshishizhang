package cn.javass.xgen.dispatch.command;

public class CmdInvoker {
	/**
	 * ���е��������
	 */
	private GenCommand cmd = null;
	/**
	 * ������Ҫ���е��������
	 * @param cmd
	 */
	public void setCmd(GenCommand cmd){
		this.cmd = cmd;
	}
	/**
	 * �ṩ���ͻ���ʹ�õķ������ÿͻ�������ִ������
	 */
	public void doCommand(){
		this.cmd.execute();
	}
}
