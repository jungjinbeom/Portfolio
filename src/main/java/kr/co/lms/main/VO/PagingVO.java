package kr.co.lms.main.VO;

public class PagingVO {
	private int pageNum = 1;		//현재 페이지
	private int onePageRecord = 4;	//한 페이지에 들어가는 레코드의 수
	private int totalPage;			//총 페이지의 수
	private int totalRecord;		//총 레코드의 수
	private int startPage = 1;		//페이지 시작
	private int pageCount = 5;		//출력되는 페이지의 수
	private int lastPageRecord = onePageRecord; //마지막 페이지에 남아있는 레코드의 수
	private String arrayKey;
	
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getOnePageRecord() {
		return onePageRecord;
	}
	public void setOnePageRecord(int onePageRecord) {
		this.onePageRecord = onePageRecord;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
		totalPage = (int)Math.ceil((double)totalRecord / onePageRecord);

		if(totalRecord % onePageRecord == 0) { //마지막 페이지 레코드 수 구하기
			lastPageRecord = onePageRecord;
		}else { 
			lastPageRecord = totalRecord % onePageRecord;
		}
//		System.out.println("총레코드수" + totalRecord);
//		System.out.println("1페이지레코드수" + onePageRecord);
//		System.out.println("마지막레코드수" + lastPageRecord);
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
		startPage = ((pageNum - 1) / pageCount ) * pageCount + 1;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getLastPageRecord() {
		return lastPageRecord;
	}
	public void setLastPageRecord(int lastPageRecord) {
		this.lastPageRecord = lastPageRecord;
	}
	public String getArrayKey() {
		return arrayKey;
	}
	public void setArrayKey(String arrayKey) {
		this.arrayKey = arrayKey;
	}
}
