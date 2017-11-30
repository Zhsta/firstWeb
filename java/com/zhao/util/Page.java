package com.zhao.util;

public class Page {
	int start=0;
	int count = 5;
	int last = 0;
	int totalPage=0;
	int total=0;
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getLast() {
		return last;
	}
	public void setLast(int last) {
		this.last = last;
	}
	public void totalPage(){

	}
	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	public void init(){
		caculateLast();
		caculateTotalPage();
	}
	public void caculateTotalPage(){
		if(total==0){
			totalPage=1;
		}
		else if((total%count)==0){
			totalPage=total/count;
		}
		else {
			totalPage=total/count+1;
		}
	}
	public void caculateLast() {
	    // 假设总数是50，是能够被5整除的，那么最后一页的开始就是45
		if(total==0){
			last=0;
		}
	    else if (0 == total % count)
	        last = total - count;
	    // 假设总数是51，不能够被5整除的，那么最后一页的开始就是50
	    else
	        last = total - total % count;		
	}

	public boolean hasNext(){
		if(start<last){
			return true;
		}
		else{
			return false;
		}
	}
	public boolean hasPrevious(){
		if(start>5){
			return true;
		}
		else {
			return false;
		}
	}
	
	
}
