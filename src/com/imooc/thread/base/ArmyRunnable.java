package com.imooc.thread.base;

//�����߳�
//ģ����ս˫������Ϊ
public class ArmyRunnable implements Runnable {

	//volatile��֤���߳̿�����ȷ�Ķ�ȡ�����߳�д���ֵ
	//�ɼ��� ref JMM��java�ڴ���� happens-beforeԭ��
	volatile boolean keepRunning = true;

	@Override
	public void run() {
		while(keepRunning){
			//����5����
			for(int i=0;i<5;i++){
				System.out.println(Thread.currentThread().getName()+"�����Է�["+i+"]");
				//�ó��˴�����ʱ�䣬�´θ�˭��������һ���أ��´�cpu�����ĸ��̲߳�ȷ��
				Thread.yield();
			}
		}
		
		System.out.println(Thread.currentThread().getName()+"������ս����");
	}

}
