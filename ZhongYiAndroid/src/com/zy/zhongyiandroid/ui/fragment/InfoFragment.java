package com.zy.zhongyiandroid.ui.fragment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.encore.libs.http.HttpConnectManager;
import com.encore.libs.http.OnRequestListener;
import com.encore.libs.utils.Log;
import com.zy.zhongyiandroid.R;
import com.zy.zhongyiandroid.ui.widget.Header;
import com.zy.zhongyiandroid.ui.widget.LoadingInfo.OnRefreshClickListener;
import com.zy.zhongyiandroid.ui.widget.list.XListView;

/**
 *健康 
 * 
 * @author Seven
 * 
 */
public class InfoFragment extends BaseFragment {
	// 第一页
	public final int FRIST_PAGE_NUMBER = 1;

	private XListView mListView;
	
	

//	private InfoListAdapter mInfoListAdapter;
//	
//	private List<ArticleCategoryTree> mArticleCategoryTrees;

	// 请求是否已经结束
	private boolean isRequesEnd = true;

	public final static String TAG = "InfoFragment";

	private int mPageNum = 1;

	private int mPageSize = 5;

	boolean mIsFirstLoad = true;


	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_info, null);

		// 初始化ui\
		initUI(view);
		initHeader(view);
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
//		initData(null);
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	/**
	 * 初始化UI
	 */
	public void initUI(View view) {
		mListView = (XListView) view.findViewById(R.id.listView);
		mListView.setHeaderDividersEnabled(false);
		mListView.setDividerHeight(0);
		mListView.setPullLoadEnable(false);
		mListView.setPullRefreshEnable(false);
		
		

//		mInfoListAdapter = new InfoListAdapter(getActivity());
//		mListView.setAdapter(mInfoListAdapter);
//		mInfoListAdapter.notifyDataSetChanged();
		
		initLoadingInfo(view);
		// 异常情况下点击刷新按钮处理
		setOnRefreshClickListener(mOnRefreshClickListener);
	}
	
	public void initHeader(View v){
		mHeader = (Header) v.findViewById(R.id.header);
		mHeader.setTitle(R.string.tab_home);
	}
	
	public void request() {
		if (!isRequesEnd) {
			return;
		}

//		isRequesEnd = false; // 改变正在请求的标识
//		if ((mPageNum == 1) && ((mArticleCategoryTrees == null) || (mArticleCategoryTrees.size() == 0))) {
//			setLoadingViewVisible(View.VISIBLE, mListView);
//		}
//		InfoHttpApi.getTopCategoryTrees(getActivity(), mOnRequestListener);
	}

	public OnRequestListener mOnRequestListener = new OnRequestListener() {

		@Override
		public void onResponse(String url, final int state, final Object result, int type) {
			mIsFirstLoad = false;
			if (!isAdded()) // fragment 已退出,返回
			{
				return;
			}
			isRequesEnd = true;
			mHandler.post(new Runnable() {

				@Override
				public void run() {
//					if ((state == HttpConnectManager.STATE_SUC) && (result != null)) {
//						MyApiResult apiResult = (MyApiResult) result;
//						List<ArticleCategoryTree> articleCategoryTrees = (List<ArticleCategoryTree>) apiResult.getResult();
//						if ((articleCategoryTrees != null) && (articleCategoryTrees.size() > 0)) {
//							initData(articleCategoryTrees);
//							onStopLoad();
//							setLoadInfoGone(mListView);
//							if (articleCategoryTrees.size() < mPageSize) {
//								mListView.setPullLoadEnable(false);
//							} else {
//								mListView.setPullLoadEnable(true);
//							}
//
//						} else {
//							mListView.setPullLoadEnable(false);
//							if ((mPageNum == 1) && ((mArticleCategoryTrees == null) || (mArticleCategoryTrees.size() == 0))) {
//								setNotDataVisible(View.VISIBLE, mListView);
//							}
//						}
//					} else if (state == HttpConnectManager.STATE_TIME_OUT) { // 请求超时
//						if ((mPageNum == 1) && ((mArticleCategoryTrees == null) || (mArticleCategoryTrees.size() == 0))) {
//							setNotNetVisible(View.VISIBLE, mListView);
//						}
//						Toast.makeText(getActivity(), R.string.time_out, Toast.LENGTH_SHORT).show();
//						mListView.setPullLoadEnable(false);
//					} else { // 请求失败
//						if ((mPageNum == 1) && ((mArticleCategoryTrees == null) || (mArticleCategoryTrees.size() == 0))) {
//							setNotNetVisible(View.VISIBLE, mListView);
//						}
//						Toast.makeText(getActivity(), R.string.request_fail, Toast.LENGTH_SHORT).show();
//						mListView.setPullLoadEnable(false);
//
//					}
				}
			});

		}
	};
	Handler mHandler = new Handler();

//	public void initData( List<ArticleCategoryTree> articleCategoryTrees) {
//		if (mListView.getAdapter() == null) {
//			mInfoListAdapter = new InfoListAdapter(getActivity());
//			mListView.setAdapter(mInfoListAdapter);
//		}
//
//		if (articleCategoryTrees == null) {// 第一次进入先读取缓存
//			// 获取缓存数据
//			if (mPageNum == 1) {
//				mArticleCategoryTrees = NetCache.readCache(HttpUrl.GET_TOP_CATEGORY_TREES);
//			}
//			// if(mGames == null&&mIsFirstLoad){
//			// //初始化，表示已经网络请求
//			// mGames = new ArrayList<NewsGame>();
//			// request();
//			// }
//			if (mIsFirstLoad||mArticleCategoryTrees==null||mArticleCategoryTrees.size()==0) {
//				request();
//			}
//			mInfoListAdapter.setDatas(mArticleCategoryTrees);
//			mInfoListAdapter.notifyDataSetChanged();
//		} else {
//			if (articleCategoryTrees.size() != 0) {
//				if (articleCategoryTrees == null) {
//					articleCategoryTrees = new ArrayList<ArticleCategoryTree>();
//				}
//				if (mPageNum == FRIST_PAGE_NUMBER) {
//					mArticleCategoryTrees = articleCategoryTrees;
//					// 保存第一页的缓存
//					try {
//						NetCache.saveCache(articleCategoryTrees, HttpUrl.GET_TOP_CATEGORY_TREES);
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				} else {
//					mArticleCategoryTrees.addAll(articleCategoryTrees);
//				}
//
//				mInfoListAdapter.setDatas(mArticleCategoryTrees);
//				mInfoListAdapter.notifyDataSetChanged();
//			} else {
//				// 判断是否有网络的情况
//				if ((mArticleCategoryTrees == null) && (mArticleCategoryTrees.size() == 0)) {
//					setNotNetVisible(View.VISIBLE, mListView);
//				}
//			}
//		}
//
//	}

	/**
	 * 刷新按钮
	 */
	private OnRefreshClickListener mOnRefreshClickListener = new OnRefreshClickListener() {

		@Override
		public void onClick(View v) {
//			initData(null); // 请求数据

		}
	};

	/** 关闭Load的显示状态 **/
	private void onStopLoad() {
		mListView.stopRefresh();
		mListView.stopLoadMore();
		mListView.setRefreshTime("刚刚");
	}


	BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {

		@Override
		public void onReceive(Context context, Intent intent) {
			mPageNum = 1;
			request();
		}

	};
}
