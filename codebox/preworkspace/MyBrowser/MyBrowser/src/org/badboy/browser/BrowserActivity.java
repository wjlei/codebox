package org.badboy.browser;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.metalev.multitouch.controller.MultiTouchController;
import org.metalev.multitouch.controller.MultiTouchController.MultiTouchObjectCanvas;
import org.metalev.multitouch.controller.MultiTouchController.PointInfo;
import org.metalev.multitouch.controller.MultiTouchController.PositionAndScale;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.webkit.DownloadListener;
import android.webkit.URLUtil;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

/***
 * 浣跨敤WebView瀵硅薄鍒涘缓涓�釜绠�崟缃戦〉娴忚鍣ㄣ�
 * @author BadBoy
 *
 */
public class BrowserActivity extends Activity implements MultiTouchObjectCanvas<Object>{
	
	//public static final String DOWNLOAD_ACTION = "android.intent.action.DOWNLOAD";
	
	private final static int MENU_NEW_WEB = Menu.FIRST;
	private final static int MENU_SET_MAIN_PAGE = MENU_NEW_WEB + 1;
	
	private String defaultGoogleUrl = "";
	private String defaultUCWebUrl = "";
	private String defaultUrl = "";
	private WebView mWebView;
	//鍌ㄥ瓨榛樿缃戝潃鏂囦欢
	private String fileUrl = "fileUrl.txt";
	//瀵硅瘽妗嗘爣璇�	
	private final static int PROGRESS_DIALOG = 110;
	private final static int SET_DEFAULT_URL_DIALOG = 111;
	//涓嬭浇杩涘害鏉℃爣璇�	
	private final static int DOWNLOAD_PROGRESS_DIALOG = 121;
	private boolean isDownload = false;
	private int downloads = 0;
	//鏄剧ず缃戦〉鍔犺浇杩涘害
	private ProgressDialog mDialog;
	private ProgressBar bar;
	//涓嬭浇杩涘害鏉℃樉绀�	
	private ProgressDialog downloadProgress;
	//澶氱偣瑙︽懜
	private MultiTouchController<Object> mMultiTouchController;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //涓嬮潰鍥涙潯璇彞瑕佸湪setContentView()鏂规硶涔嬪墠璋冪敤锛屽惁鍒欑▼搴忎細鍑洪敊锛屽湪鏈▼搴忎腑锛屽姞鍏ヤ互涓嬬殑璇彞璨屼技杩樻病鏈変粈涔堝奖鍝�鎴栬�鏈夋垜杩樻病鍙戠幇
        this.requestWindowFeature(Window.FEATURE_LEFT_ICON);
        this.requestWindowFeature(Window.FEATURE_RIGHT_ICON);
        this.requestWindowFeature(Window.FEATURE_PROGRESS);
        this.requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        
        setContentView(R.layout.main);
        initWebView();
        performSearchIntent(getIntent());
        
        
    }
	
	@Override
	protected void onNewIntent(Intent intent) {
		setIntent(intent);
		performSearchIntent(intent);
	}
	/**
	 * 鎵ц鎼滅储锛屾墦寮�綉椤�	 */
	private void performSearchIntent(Intent intent) {
		if(Intent.ACTION_SEARCH.equals(intent.getAction())){
        	String query = intent.getStringExtra(SearchManager.QUERY);
        	//杩樻病鏈夊缃戝潃杩涜涓ユ牸鐨勮В鏋�			
        	if(!query.startsWith("http://")){
        		mWebView.loadUrl("http://"+query);
        	}
        	if(query.startsWith("http://")){
        		mWebView.loadUrl(query);
        	}
        	/*else{
        		Toast.makeText(this, R.string.url_error, Toast.LENGTH_SHORT).show();
        	}*/
        }
	}
	
	private void initWebView() {
		defaultGoogleUrl = this.getResources().getString(R.string.default_google_url);
		defaultUCWebUrl = this.getResources().getString(R.string.default_ucweb_url);
		setDefaultURL();
		
		bar = (ProgressBar)findViewById(R.id.progress_bar);
		
		mMultiTouchController = new MultiTouchController<Object>(this,false);
		
		mWebView = (WebView)findViewById(R.id.webview);
        //浣跨敤mWebView鐨刧etSettings()鏂规硶璁剧疆鏀寔JavaScript涓簍rue
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setScrollBarStyle(0);
        //鐢╨oadUrl鏂规硶鍔犺浇缃戝潃
        mWebView.loadUrl(defaultUrl);
        //瀵筸WebView璁剧疆WebViewClient瀵硅薄,濡傛灉涓嶈缃瀵硅薄閭ｄ箞褰撳崟鍑籱WebView涓殑閾炬帴鏃跺皢鐢辩郴缁�        //榛樿鐨凚rowser鏉ュ搷搴旈摼鎺ワ紝鍗崇敱榛樿鐨凚rowser鎵撳紑閾炬帴锛岃�涓嶆槸浣犺嚜宸卞啓鐨凚rowser鏉ユ墦寮�        //鏁呬负浜唌WebView鑷繁澶勭悊椤甸潰涓殑鎵�湁閾炬帴锛屽垯瑕佹墿灞昗ebViewClient绫伙紝閲嶈浇shouldOverrideUrlLoading()鏂规硶
        mWebView.setWebViewClient(new MyWebViewClient());
        //
        mWebView.setWebChromeClient(new MyWebChromeClient());
        //瀹炵幇涓嬭浇鐩戝惉
		mWebView.setDownloadListener(new DownloadListener(){

			public void onDownloadStart(String url, String userAgent, String contentDisposition,
					String mimetype, long contentLength) {
				/*Uri uri = Uri.parse(url);
				Intent intent = new Intent(DOWNLOAD_ACTION,uri);
				startActivity(intent);*/
				
				//downloadFile(url, mimetype, mimetype, mimetype, contentLength);
				ContentValues values = new ContentValues();
				values.put(Downloads.COLUMN_URI, url);
			}
			
		});
	}
	/*
	 * 涓嬪垪浠ｇ爜瀹炵幇缃戠粶鏂囦欢涓嬭浇鍔熻兘锛岀洰鍓嶄笅杞界殑鏂囦欢鏃跺瓨鍌ㄥ湪/data/data/org.badboy.browser/files鐩綍涓嬬殑銆�	 * 鍚庣画杩樹細鏇存柊杩欎釜鏂规硶锛屽皢鍏朵笅杞藉埌SDCard涓婃潵銆傛�璺槸杩欐牱瀛愮殑锛氫笅杞芥枃浠舵椂鍏堟鏌ユ槸鍚︾敱sdcard鎴杣disk澶栧瓨鍌ㄨ澶囷紝
	 * 鑻ユ湁鍒欑洿鎺ヤ笅杞藉埌澶栧瓨鍌ㄨ澶囷紝鍚﹀垯瀛樺偍鍒�data/data/org.badboy.browser/files鐩綍涓�鏈�悗杩樿澧炲姞涓�釜鍔熻兘锛氬氨鏄�	 * 鍒楀嚭宸蹭笅杞芥枃浠讹紝浠ュ強瀵规枃浠禼opy锛宒elete绛夋搷浣滐紝涓嬭浇杩涘害鏉°�
	 * 2011-3-4
	 */
	private void downloadFile(String url,String userAgent, String contentDisposition,
			String mimetype, long contentLength) {
		
		/*String filename = URLUtil.guessFileName(url,
                contentDisposition, mimetype);
		// Check to see if we have an SDCard
        String status = Environment.getExternalStorageState();
        if (!status.equals(Environment.MEDIA_MOUNTED)) {
            int title;
            String msg;

            // Check to see if the SDCard is busy, same as the music app
            if (status.equals(Environment.MEDIA_SHARED)) {
                msg = getString(R.string.download_sdcard_busy_dlg_msg);
                title = R.string.download_sdcard_busy_dlg_title;
            } else {
                msg = getString(R.string.download_no_sdcard_dlg_msg, filename);
                title = R.string.download_no_sdcard_dlg_title;
            }

            new AlertDialog.Builder(this)
                .setTitle(title)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setMessage(msg)
                .setPositiveButton(R.string.ok, null)
                .show();
            return;
        }*/
		isDownload = true;
		
		
		try {
			String filename = URLUtil.guessFileName(url,
	                contentDisposition, mimetype);
			URL url2 = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) url2.openConnection();
			conn.setDoInput(true);
			conn.connect();
			if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
				InputStream is = conn.getInputStream();
				FileOutputStream fos = this.openFileOutput(filename, Context.MODE_APPEND);
				int len = 0;
				byte[] buf = new byte[1024];
				while ((len = is.read(buf)) != -1) {
					fos.write(buf, 0, len);
					
				}
				is.close();
				fos.close();
				isDownload = false;
			} else {
				Toast.makeText(this, R.string.net_error, Toast.LENGTH_SHORT).show();
				isDownload = false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			isDownload = false;
		}
		
	}

	private void setDefaultURL() {
		try {
			//android涓娇鐢╫penFileInput()鏂规硶寰楀埌鏂囦欢杈撳叆娴�			
			FileInputStream fis = this.openFileInput(fileUrl);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int len = 0;
			while((len = fis.read(buffer))!=-1){
				baos.write(buffer, 0, len);
			}
			//defaultUrl = new String(buffer,0,len);
			defaultUrl = baos.toString();
			fis.close();
			baos.close();
		} catch (Exception e) {
			e.printStackTrace();
			defaultUrl = defaultGoogleUrl;
		}
		//濡傛灉杩樻槸涓虹┖(鍗虫枃浠朵腑杩樻病鏈夊瓨鍌ㄩ粯璁ょ綉鍧�锛屽垯浣跨敤defaultUCWebUrl
		if(defaultUrl.equals("")){
			defaultUrl = defaultGoogleUrl;//defaultUCWebUrl;
		}
	}
	/**
	 * 鎸夐敭浜嬩欢澶勭悊
	 */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		//鎸夎繑鍥為敭鍙�鍥炰箣鍓嶆祻瑙堣繃鐨勭綉椤�		
		if((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()){
			mWebView.goBack();
			return true;
		}
		//鎼滅储鎸夐敭
		if(keyCode == KeyEvent.KEYCODE_SEARCH){
			onSearchRequested();
		}
		return super.onKeyDown(keyCode, event);
	}
	/**
	 * 閲嶅啓WebChromeClient绫�	 */
	private class MyWebChromeClient extends WebChromeClient {
		//璁剧疆缃戦〉鍔犺浇杩涘害鏉�		@Override
		public void onProgressChanged(WebView webview, int newProgress){
			BrowserActivity.this.getWindow().setFeatureInt(Window.FEATURE_PROGRESS, 100);
			//浠ヤ笅娉ㄩ噴浠ｇ爜鏄敤鏉rogressDialog鏄剧ず缃戦〉鍔犺浇杩涘害鐨�			
			/*showDialog(PROGRESS_DIALOG);
			mDialog.setProgress(newProgress);
			if(newProgress==100){
				dismissDialog(PROGRESS_DIALOG);
			}*/
			/*//涓嬭浇鏃舵樉绀轰笅杞借繘搴�			if(isDownload){
				showDialog(DOWNLOAD_PROGRESS_DIALOG);
				downloadProgress.setProgress(newProgress);
			}
			if(newProgress==100){
				dismissDialog(DOWNLOAD_PROGRESS_DIALOG);
			}*/
			//浠ヤ笅浠ｇ爜鏄敤鏉rogressBar鏄剧ず缃戦〉鍔犺浇杩涘害鐨�			
			bar.setProgress(newProgress);
			bar.setVisibility(View.VISIBLE);
			if(bar.getProgress()==100){
				bar.setVisibility(View.GONE);
			}
			super.onProgressChanged(webview, newProgress);
		}
	}
	/**
	 * 閲嶅啓 WebViewClient绫�鐢辨湰Browser澶勭悊缃戦〉涓殑閾炬帴
	 */
	private class MyWebViewClient extends WebViewClient {

		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			view.loadUrl(url);
			return true;
		}
		
	}
	/**
	 * Menu 鎸夐敭鐨勬坊鍔犲拰浜嬩欢澶勭悊
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		//鎵撳紑缃戝潃杈撳叆鏍�		
		menu.add(0,MENU_NEW_WEB,0,R.string.new_web_page)
			.setIcon(R.drawable.search_icon);
		//璁剧疆榛樿缃戝潃
		menu.add(0,MENU_SET_MAIN_PAGE,0,R.string.set_default_url)
		.setIcon(R.drawable.browser_icon);
		return super.onCreateOptionsMenu(menu);
	}
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		switch(item.getItemId()){
		case MENU_NEW_WEB:
			onSearchRequested();
			return true;
		case MENU_SET_MAIN_PAGE:
			this.showDialog(SET_DEFAULT_URL_DIALOG);
			break;
		}
		return super.onMenuItemSelected(featureId, item);
	}
	
	/**
	 * 閲嶅啓onSearchRequested(),鍙疄鐜拌皟鐢⊿earch Bar
	 */
	@Override
	public boolean onSearchRequested() {
		//鏈▼搴忚繕娌″鐞咮undle瀵硅薄浼犳潵鐨勬暟鎹紝娉ㄩ噴涓嬪垪涓夎浠ｇ爜
		/*Bundle appData = new Bundle();
		appData.putBoolean("search",true);
		this.startSearch(null, false, appData, false);*/
		this.startSearch(null, false, null, false);
		return true;
	}
	/**
	 * 褰撹璋冪敤this.showDialog(int id)鏂规硶鏉ユ樉绀篋ialog鏃讹紝瑕侀噸鍐欎笅鍒楁柟娉�	 */
	@Override
	protected Dialog onCreateDialog(int id) {
		switch(id){
		case PROGRESS_DIALOG:
			mDialog = new ProgressDialog(this);
			//mDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			mDialog.setMessage(getString(R.string.page_is_loading));
			return mDialog;
		case SET_DEFAULT_URL_DIALOG:
			return createDefaultUrlDialog();
		case DOWNLOAD_PROGRESS_DIALOG:
			return createDownloadProgress();
		default:
			return super.onCreateDialog(id);
		}
		
	}
	private Dialog createDownloadProgress() {
		downloadProgress = new ProgressDialog(this);
		downloadProgress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		downloadProgress.setMessage(getString(R.string.file_is_loading));
		return downloadProgress;
	}

	private Dialog createDefaultUrlDialog() {
		final Dialog dialog = new Dialog(this);
		dialog.setContentView(R.layout.default_url_dialog);
		dialog.setTitle(R.string.dialog_title);
		final EditText url = (EditText)dialog.findViewById(R.id.url);
		Button btnOK = (Button)dialog.findViewById(R.id.ok_btn);
		btnOK.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				defaultUrl = url.getText().toString();
				try {
					FileOutputStream fos = BrowserActivity.this.openFileOutput(fileUrl, Context.MODE_PRIVATE);
					byte[] buffer = defaultUrl.getBytes();
					fos.write(buffer);
					fos.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				dialog.dismiss();
				mWebView.loadUrl(defaultUrl);
			}
		});
		Button btnCancel = (Button)dialog.findViewById(R.id.cancel_btn);
		btnCancel.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				dialog.dismiss();
			}
		});
		return dialog;
	}

	/**
	 * 灞忓箷鏃嬭浆鏃讹紝绋嬪簭浼氶噸鏂拌皟鐢╫nCreate()鏂规硶锛屽嵆閲嶆柊鍔犺浇绋嬪簭銆傚綋涓嶉渶瑕佽繖涔堝仛鏃讹紝
	 * 鍙湪manifest鏂囦欢涓殑Activity鏍囩涓姞鍏ndroid:configChanges="orientation|keyboardHidden"
	 * 灞炴�锛屽苟涓旈噸鍐欎笅鍒楁柟娉曘�璇ユ柟娉曚腑鍙互澶勭悊灞忓箷鏃嬭浆鏃跺彂鐢熺殑鍔ㄤ綔
	 */
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		
		/*if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
			
		} else if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
			
		}*/

		super.onConfigurationChanged(newConfig);
	}
	
	//-------------multitouch stuff ------------------------------------
	
	private int mCurrentZoom = 0;
	private static final double ZOOM_SENSITIVITY = 1.6;
	private static final float ZOOM_LOG_BASE_INV = 1.0f / (float) Math.log(2.0 / ZOOM_SENSITIVITY);
	private boolean isMultiTouchScale = false;
	@Override 
	public boolean dispatchTouchEvent(MotionEvent event) {
		if (mMultiTouchController.onTouchEvent(event)) {
			if (!isMultiTouchScale) {
				event.setAction(MotionEvent.ACTION_CANCEL);
				super.dispatchTouchEvent(event);
			}
		}else{
			isMultiTouchScale = true;
			 if (super.dispatchTouchEvent(event)) {
				 return true;
			 }
			 return false;
		}
		return true;
	}
	public Object getDraggableObjectAtPoint(PointInfo touchPoint) {
		return new Object();
	}

	public void getPositionAndScale(Object obj,
			PositionAndScale objPosAndScaleOut) {
		objPosAndScaleOut.set(0.0f, 0.0f, true, 1.0f, false, 0.0f, 0.0f, false, 0.0f);
		mCurrentZoom = 0;
	}

	public void selectObject(Object obj, PointInfo touchPoint) {
		
	}

	public boolean setPositionAndScale(Object obj,
			PositionAndScale newObjPosAndScale, PointInfo touchPoint) {
		float newRelativeScale = newObjPosAndScale.getScale();
		int targetZoom = (int) Math.round(Math.log(newRelativeScale)
				* ZOOM_LOG_BASE_INV);
		while (mCurrentZoom > targetZoom) {
			mCurrentZoom--;
			mWebView.zoomOut();
		}
		while (mCurrentZoom < targetZoom) {
			mCurrentZoom++;
			mWebView.zoomIn();
		}
		return true;
	}
	
}