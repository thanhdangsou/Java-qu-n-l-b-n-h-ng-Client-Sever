package com.qlbh.controller;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.jfoenix.controls.JFXButton;
import com.qlbh.app.MainApp;
import com.qlbh.controller.common.DialogConfirmController;
import com.qlbh.controller.common.DialogController;
import com.qlbh.controller.hethong.BackupDataController;
import com.qlbh.controller.hethong.DoiMatKhauController;
import com.qlbh.controller.hethong.RestoreDataController;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

public class ManHinhChinhController {
	final static Logger logger = Logger.getLogger(ManHinhChinhController.class);

	@FXML
	private TabPane tabMainContent;

	@FXML
	private AnchorPane anchorPaneMainApp;

	@FXML
	private JFXButton btnThongTin, btnThongTinTroGiup, btnBoPhan, btnNhatKyHeThong, btnBackup, btnPhanQuyen, btnBackUp,
			btnPhucHoi, btnQuanLyKhuVuc, btnQuanLyKhachHang, btnQuanLyNhaCungCap, btnQuanLyKhoHang, btnNhanVien,
			btnBaoCaoKhoHang, btnBaoCaoBanHang, btnChungTu, btnMuaHang, btnBanHang;
	@FXML
	private Text lblStatus;

	@FXML
	private AnchorPane anchorManHinhChinhRoot;

	public void setStatusAndRoles() {
		if (MainApp.loginUser != null) {
			String status = MainApp.loginUser.getQuyen().getTen() + " - " + MainApp.loginUser.getNhanvien().getTen();
			lblStatus.setText(status);
		}
		switch (MainApp.loginUser.getQuyen().getId()) {
		case 2:
			btnPhanQuyen.setDisable(true);
			btnNhatKyHeThong.setDisable(true);
			btnBackUp.setDisable(true);
			btnPhucHoi.setDisable(true);
			btnMuaHang.setDisable(true);
			btnBanHang.setDisable(true);
			break;
		case 3:
			btnPhanQuyen.setDisable(true);
			btnNhatKyHeThong.setDisable(true);
			btnBackUp.setDisable(true);
			btnPhucHoi.setDisable(true);
			btnQuanLyKhuVuc.setDisable(true);
			btnQuanLyKhachHang.setDisable(true);
			btnQuanLyNhaCungCap.setDisable(true);
			btnQuanLyKhoHang.setDisable(true);
			btnBoPhan.setDisable(true);
			btnNhanVien.setDisable(true);
			btnBaoCaoKhoHang.setDisable(true);
			btnBaoCaoBanHang.setDisable(true);
			btnChungTu.setDisable(true);
			break;
		default:
			break;
		}
	}

	public static Tab tabNhapHang = null;

	@FXML
	void btnMuaHangClick(ActionEvent event) {
		String title = "Nh???p h??ng";
		String fxmlPath = "../fxml/chucnang/NhapHang.fxml";
		if (ManHinhChinhController.tabNhapHang != null) {
			tabMainContent.getSelectionModel().select(ManHinhChinhController.tabNhapHang);
			return;
		}
		Tab tab = new Tab();
		tab.setText(title);
		tab.setOnClosed(new EventHandler<Event>() {
			public void handle(Event arg0) {
				ManHinhChinhController.tabNhapHang = null;
			}
		});
		try {
			Parent root = (Parent) FXMLLoader.load(getClass().getResource(fxmlPath));
			tab.setContent(root);
			tabMainContent.getTabs().add(tab);
			tabMainContent.getSelectionModel().select(tab);
			ManHinhChinhController.tabNhapHang = tab;

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Tab tabBanHang = null;

	@FXML
	void btnBanHangOnClick(ActionEvent event) {
		String title = "B??n h??ng";
		String fxmlPath = "../fxml/chucnang/XuatHang.fxml";
		if (ManHinhChinhController.tabBanHang != null) {
			tabMainContent.getSelectionModel().select(ManHinhChinhController.tabBanHang);
			return;
		}
		Tab tab = new Tab();
		tab.setText(title);
		tab.setOnClosed(new EventHandler<Event>() {
			public void handle(Event arg0) {
				ManHinhChinhController.tabBanHang = null;
			}
		});
		try {
			Parent root = (Parent) FXMLLoader.load(getClass().getResource(fxmlPath));
			tab.setContent(root);
			tabMainContent.getTabs().add(tab);
			tabMainContent.getSelectionModel().select(tab);
			ManHinhChinhController.tabBanHang = tab;

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Tab tabTonKho = null;

	@FXML
	void btnTonKhoClick(ActionEvent event) {
		String title = "T???n kho";
		String fxmlPath = "../fxml/chucnang/TonKho.fxml";
		if (ManHinhChinhController.tabTonKho != null) {
			tabMainContent.getSelectionModel().select(ManHinhChinhController.tabTonKho);
			return;
		}
		Tab tab = new Tab();
		tab.setText(title);
		tab.setOnClosed(new EventHandler<Event>() {
			public void handle(Event arg0) {
				ManHinhChinhController.tabTonKho = null;
			}
		});
		try {
			Parent root = (Parent) FXMLLoader.load(getClass().getResource(fxmlPath));
			tab.setContent(root);
			tabMainContent.getTabs().add(tab);
			tabMainContent.getSelectionModel().select(tab);
			ManHinhChinhController.tabTonKho = tab;

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Tab tabKhuVuc = null;

	@FXML
	void btnQuanLyKhuVucClick(ActionEvent event) {
		String title = "Khu v???c";
		String fxmlPath = "../fxml/danhmuc/QuanLyKhuVuc.fxml";
		if (ManHinhChinhController.tabKhuVuc != null) {
			tabMainContent.getSelectionModel().select(ManHinhChinhController.tabKhuVuc);
			return;
		}
		Tab tab = new Tab();
		tab.setText(title);
		tab.setOnClosed(new EventHandler<Event>() {
			public void handle(Event arg0) {
				ManHinhChinhController.tabKhuVuc = null;
			}
		});
		try {
			Parent root = (Parent) FXMLLoader.load(getClass().getResource(fxmlPath));
			tab.setContent(root);
			tabMainContent.getTabs().add(tab);
			tabMainContent.getSelectionModel().select(tab);
			ManHinhChinhController.tabKhuVuc = tab;

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Tab tabNhaCungCap = null;

	@FXML
	void btnQuanLyNhaCungCapClick(ActionEvent event) {
		String title = "Nh?? cung c???p";
		String fxmlPath = "../fxml/danhmuc/QuanLyNhaCungCap.fxml";
		if (ManHinhChinhController.tabNhaCungCap != null) {
			tabMainContent.getSelectionModel().select(ManHinhChinhController.tabNhaCungCap);
			return;
		}
		Tab tab = new Tab();
		tab.setText(title);
		tab.setOnClosed(new EventHandler<Event>() {
			public void handle(Event arg0) {
				ManHinhChinhController.tabNhaCungCap = null;
			}
		});
		try {
			Parent root = (Parent) FXMLLoader.load(getClass().getResource(fxmlPath));
			tab.setContent(root);
			tabMainContent.getTabs().add(tab);
			tabMainContent.getSelectionModel().select(tab);
			ManHinhChinhController.tabNhaCungCap = tab;

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Tab tabKhoHang = null;

	@FXML
	void btnQuanLyKhoHangClick(ActionEvent event) {
		String title = "Kho h??ng";
		String fxmlPath = "../fxml/danhmuc/QuanLyKhoHang.fxml";
		if (ManHinhChinhController.tabKhoHang != null) {
			tabMainContent.getSelectionModel().select(ManHinhChinhController.tabKhoHang);
			return;
		}
		Tab tab = new Tab();
		tab.setText(title);
		tab.setOnClosed(new EventHandler<Event>() {
			public void handle(Event arg0) {
				ManHinhChinhController.tabKhoHang = null;
			}
		});
		try {
			Parent root = (Parent) FXMLLoader.load(getClass().getResource(fxmlPath));
			tab.setContent(root);
			tabMainContent.getTabs().add(tab);
			tabMainContent.getSelectionModel().select(tab);
			ManHinhChinhController.tabKhoHang = tab;

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Tab tabDonViTinh = null;

	@FXML
	void btnQuanLyDonViTinhClick(ActionEvent event) {
		String title = "????n v??? t??nh";
		String fxmlPath = "../fxml/danhmuc/QuanLyDonViTinh.fxml";
		if (ManHinhChinhController.tabDonViTinh != null) {
			tabMainContent.getSelectionModel().select(ManHinhChinhController.tabDonViTinh);
			return;
		}
		Tab tab = new Tab();
		tab.setText(title);
		tab.setOnClosed(new EventHandler<Event>() {
			public void handle(Event arg0) {
				ManHinhChinhController.tabDonViTinh = null;
			}
		});
		try {
			Parent root = (Parent) FXMLLoader.load(getClass().getResource(fxmlPath));
			tab.setContent(root);
			tabMainContent.getTabs().add(tab);
			tabMainContent.getSelectionModel().select(tab);
			ManHinhChinhController.tabDonViTinh = tab;

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Tab tabNhomHangHoa = null;

	@FXML
	void btnQuanLyLoaiHangClick(ActionEvent event) {
		String title = "Nh??m h??ng h??a";
		String fxmlPath = "../fxml/danhmuc/QuanLyNhomHangHoa.fxml";
		if (ManHinhChinhController.tabNhomHangHoa != null) {
			tabMainContent.getSelectionModel().select(ManHinhChinhController.tabNhomHangHoa);
			return;
		}
		Tab tab = new Tab();
		tab.setText(title);
		tab.setOnClosed(new EventHandler<Event>() {
			public void handle(Event arg0) {
				ManHinhChinhController.tabNhomHangHoa = null;
			}
		});
		try {
			Parent root = (Parent) FXMLLoader.load(getClass().getResource(fxmlPath));
			tab.setContent(root);
			tabMainContent.getTabs().add(tab);
			tabMainContent.getSelectionModel().select(tab);
			ManHinhChinhController.tabNhomHangHoa = tab;

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Tab tabKhachHang = null;

	@FXML
	void onButtonKhachHangClick(ActionEvent event) {
		String title = "Kh??ch h??ng";
		String fxmlPath = "../fxml/danhmuc/KhachHang.fxml";
		// Check tab KhachHang added or not? If added, switch to this tab
		if (ManHinhChinhController.tabKhachHang != null) {
			tabMainContent.getSelectionModel().select(ManHinhChinhController.tabKhachHang);
			return;
		}
		Tab tab = new Tab();
		tab.setText(title);
		tab.setOnClosed(new EventHandler<Event>() {
			public void handle(Event arg0) {
				ManHinhChinhController.tabKhachHang = null;
			}
		});
		Parent root;
		try {
			root = (Parent) FXMLLoader.load(getClass().getResource(fxmlPath));
			tab.setContent(root);
			tabMainContent.getTabs().add(tab);
			tabMainContent.getSelectionModel().select(tab);
			ManHinhChinhController.tabKhachHang = tab;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Tab tabTyGia = null;

	@FXML
	void onButtonTyGiaClick(ActionEvent event) {
		String title = "T??? gi??";
		String fxmlPath = "../fxml/danhmuc/TyGia.fxml";
		if (ManHinhChinhController.tabTyGia != null) {
			tabMainContent.getSelectionModel().select(ManHinhChinhController.tabTyGia);
			return;
		}
		Tab tab = new Tab();
		tab.setText(title);
		tab.setOnClosed(new EventHandler<Event>() {
			public void handle(Event arg0) {
				ManHinhChinhController.tabTyGia = null;
			}
		});
		Parent root;
		try {
			root = (Parent) FXMLLoader.load(getClass().getResource(fxmlPath));
			tab.setContent(root);
			tabMainContent.getTabs().add(tab);
			tabMainContent.getSelectionModel().select(tab);
			ManHinhChinhController.tabTyGia = tab;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Tab tabTraTien = null;

	@FXML
	void onButtonTraTienClick(ActionEvent event) {
		String title = "Tr??? ti???n";
		String fxmlPath = "../fxml/chucnang/TraTien.fxml";
		if (ManHinhChinhController.tabTraTien != null) {
			tabMainContent.getSelectionModel().select(ManHinhChinhController.tabTraTien);
			return;
		}
		Tab tab = new Tab();
		tab.setText(title);
		tab.setOnClosed(new EventHandler<Event>() {
			public void handle(Event arg0) {
				ManHinhChinhController.tabTraTien = null;
			}
		});
		Parent root;
		try {
			root = (Parent) FXMLLoader.load(getClass().getResource(fxmlPath));
			tab.setContent(root);
			tabMainContent.getTabs().add(tab);
			tabMainContent.getSelectionModel().select(tab);
			ManHinhChinhController.tabTraTien = tab;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Tab tabChuyenKho = null;

	@FXML
	void buttonChuyenKhoClick(ActionEvent event) {
		String title = "Chuy???n kho";
		String fxmlPath = "../fxml/chucnang/ChuyenKho.fxml";
		if (ManHinhChinhController.tabChuyenKho != null) {
			tabMainContent.getSelectionModel().select(ManHinhChinhController.tabChuyenKho);
			return;
		}
		Tab tab = new Tab();
		tab.setText(title);
		tab.setOnClosed(new EventHandler<Event>() {
			public void handle(Event arg0) {
				ManHinhChinhController.tabChuyenKho = null;
			}
		});
		Parent root;
		try {
			root = (Parent) FXMLLoader.load(getClass().getResource(fxmlPath));
			tab.setContent(root);
			tabMainContent.getTabs().add(tab);
			tabMainContent.getSelectionModel().select(tab);
			ManHinhChinhController.tabChuyenKho = tab;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Tab tabThuTien = null;

	@FXML
	void onButtonThuTienClick(ActionEvent event) {
		String title = "Thu ti???n";
		String fxmlPath = "../fxml/chucnang/ThuTien.fxml";
		if (ManHinhChinhController.tabThuTien != null) {
			tabMainContent.getSelectionModel().select(ManHinhChinhController.tabThuTien);
			return;
		}
		Tab tab = new Tab();
		tab.setText(title);
		tab.setOnClosed(new EventHandler<Event>() {
			public void handle(Event arg0) {
				ManHinhChinhController.tabThuTien = null;
			}
		});
		Parent root;
		try {
			root = (Parent) FXMLLoader.load(getClass().getResource(fxmlPath));
			tab.setContent(root);
			tabMainContent.getTabs().add(tab);
			tabMainContent.getSelectionModel().select(tab);
			ManHinhChinhController.tabThuTien = tab;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Tab tabBaoCaoKhoHang = null;

	@FXML
	void onButtonBaoCaoKhoHangClick(ActionEvent event) {
		String title = "B??o c??o t???ng h???p kho";
		String fxmlPath = "../fxml/chucnang/BaoCaoKhoHang.fxml";
		if (ManHinhChinhController.tabBaoCaoKhoHang != null) {
			tabMainContent.getSelectionModel().select(ManHinhChinhController.tabBaoCaoKhoHang);
			return;
		}
		Tab tab = new Tab();
		tab.setText(title);
		tab.setOnClosed(new EventHandler<Event>() {
			public void handle(Event arg0) {
				ManHinhChinhController.tabBaoCaoKhoHang = null;
			}
		});
		Parent root;
		try {
			root = (Parent) FXMLLoader.load(getClass().getResource(fxmlPath));
			tab.setContent(root);
			tabMainContent.getTabs().add(tab);
			tabMainContent.getSelectionModel().select(tab);
			ManHinhChinhController.tabBaoCaoKhoHang = tab;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Tab tabBaoCaoBanHang = null;

	@FXML
	void onButtonBaoCaoBanHangClick(ActionEvent event) {
		String title = "B??o c??o b??n h??ng";
		String fxmlPath = "../fxml/chucnang/BaoCaoBanHang.fxml";
		if (ManHinhChinhController.tabBaoCaoBanHang != null) {
			tabMainContent.getSelectionModel().select(ManHinhChinhController.tabBaoCaoBanHang);
			return;
		}
		Tab tab = new Tab();
		tab.setText(title);
		tab.setOnClosed(new EventHandler<Event>() {
			public void handle(Event arg0) {
				ManHinhChinhController.tabBaoCaoBanHang = null;
			}
		});
		Parent root;
		try {
			root = (Parent) FXMLLoader.load(getClass().getResource(fxmlPath));
			tab.setContent(root);
			tabMainContent.getTabs().add(tab);
			tabMainContent.getSelectionModel().select(tab);
			ManHinhChinhController.tabBaoCaoBanHang = tab;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void btnKetThucClick(ActionEvent event) {
		MainApp.getPrimaryStage().close();
	}

	public static Tab tabPhanQuyen = null;

	@FXML
	void btnPhanQuyenClick(ActionEvent event) {
		String title = "Ph??n quy???n";
		String fxmlPath = "../fxml/hethong/QuanLyNguoiDung.fxml";
		if (ManHinhChinhController.tabPhanQuyen != null) {
			tabMainContent.getSelectionModel().select(ManHinhChinhController.tabPhanQuyen);
			return;
		}
		Tab tab = new Tab();
		tab.setText(title);
		tab.setOnClosed(new EventHandler<Event>() {
			public void handle(Event arg0) {
				ManHinhChinhController.tabPhanQuyen = null;
			}
		});
		try {
			Parent root = (Parent) FXMLLoader.load(getClass().getResource(fxmlPath));
			tab.setContent(root);
			tabMainContent.getTabs().add(tab);
			tabMainContent.getSelectionModel().select(tab);
			ManHinhChinhController.tabPhanQuyen = tab;

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void btnThongTinClick(ActionEvent event) {
		Stage primaryStage = new Stage();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("../fxml/trogiup/ThongTin.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("Th??ng tin");
			primaryStage.initStyle(StageStyle.UNIFIED);
			primaryStage.initModality(Modality.APPLICATION_MODAL);
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("../images/appIcon.png")));
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void btnThongTinTroGiupClick(ActionEvent event) {
		Stage primaryStage = new Stage();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("../fxml/trogiup/ThongTin.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("Th??ng tin");
			primaryStage.initStyle(StageStyle.UNIFIED);
			primaryStage.initModality(Modality.APPLICATION_MODAL);
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("../images/appIcon.png")));
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	private void onButtonNhapDanhMucTuExcelClick() {
		System.out.println("onButtonNhapDanhMucTuExcelClick");
	}

	@FXML
	void btnDoiMatKhauClick(ActionEvent event) {
		Stage primaryStage = new Stage();
		Parent root;
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/hethong/DoiMatKhau.fxml"));
			root = loader.load();
			Scene scene = new Scene(root);
			DoiMatKhauController doiMatKhauCtrl = loader.<DoiMatKhauController>getController();
			primaryStage.setTitle("?????i m???t kh???u");
			primaryStage.initStyle(StageStyle.UNIFIED);
			primaryStage.initModality(Modality.APPLICATION_MODAL);
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("../images/appIcon.png")));
			primaryStage.show();
			primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
				public void handle(WindowEvent we) {
					if (doiMatKhauCtrl.isDoiMatKhauThanhCong()) {
						DialogController.show(anchorManHinhChinhRoot, null, "Th??ng b??o", "?????i m???t kh???u th??nh c??ng.");
						primaryStage.close();
					}
				}
			});
		} catch (IOException e) {
			logger.error("exeption open frmDoiMatKhau", e);
			e.printStackTrace();
		}
	}

	public static Tab tabBoPhan = null;

	@FXML
	void btnBoPhanClick(ActionEvent event) {
		String title = "DS b??? ph???n";
		String fxmlPath = "../fxml/danhmuc/DanhSachBoPhan.fxml";
		if (ManHinhChinhController.tabBoPhan != null) {
			tabMainContent.getSelectionModel().select(ManHinhChinhController.tabBoPhan);
			return;
		}
		Tab tab = new Tab();
		tab.setText(title);
		tab.setOnClosed(new EventHandler<Event>() {
			public void handle(Event arg0) {
				ManHinhChinhController.tabBoPhan = null;
			}
		});
		Parent root;
		try {
			root = (Parent) FXMLLoader.load(getClass().getResource(fxmlPath));
			tab.setContent(root);
			tabMainContent.getTabs().add(tab);
			tabMainContent.getSelectionModel().select(tab);
			ManHinhChinhController.tabBoPhan = tab;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error("exeption open tabBoPhan", e);
			e.printStackTrace();
		}
	}

	public static Tab tabNhanVien = null;

	@FXML
	void btnNhanVienClick(ActionEvent event) {
		String title = "DS Nh??n vi??n";
		String fxmlPath = "../fxml/danhmuc/DanhSachNhanVien.fxml";
		if (ManHinhChinhController.tabNhanVien != null) {
			tabMainContent.getSelectionModel().select(ManHinhChinhController.tabNhanVien);
			return;
		}
		Tab tab = new Tab();
		tab.setText(title);
		tab.setOnClosed(new EventHandler<Event>() {
			public void handle(Event arg0) {
				ManHinhChinhController.tabNhanVien = null;
			}
		});
		Parent root;
		try {
			root = (Parent) FXMLLoader.load(getClass().getResource(fxmlPath));
			tab.setContent(root);
			tabMainContent.getTabs().add(tab);
			tabMainContent.getSelectionModel().select(tab);
			ManHinhChinhController.tabNhanVien = tab;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error("exeption open tabNhanVien", e);
			e.printStackTrace();
		}
	}

	public static Tab tabNhatKy = null;

	@FXML
	void btnNhatKyHeThongClick(ActionEvent event) {
		String title = "Nh???t k?? h??? th???ng";
		String fxmlPath = "../fxml/hethong/NhatKyHeThong.fxml";
		if (ManHinhChinhController.tabNhatKy != null) {
			tabMainContent.getSelectionModel().select(ManHinhChinhController.tabNhatKy);
			return;
		}
		Tab tab = new Tab();
		tab.setText(title);
		tab.setOnClosed(new EventHandler<Event>() {
			public void handle(Event arg0) {
				ManHinhChinhController.tabNhatKy = null;
			}
		});
		Parent root;
		try {
			root = (Parent) FXMLLoader.load(getClass().getResource(fxmlPath));
			tab.setContent(root);
			tabMainContent.getTabs().add(tab);
			tabMainContent.getSelectionModel().select(tab);
			ManHinhChinhController.tabNhatKy = tab;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error("exeption open tabNhatKyHeThong", e);
			e.printStackTrace();
		}
	}

	@FXML
	void btnBackUpClick(ActionEvent event) {
		Stage primaryStage = new Stage();
		Parent root;
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/hethong/BackupData.fxml"));
			root = loader.load();
			Scene scene = new Scene(root);
			BackupDataController backUpDataCtrl = loader.<BackupDataController>getController();
			primaryStage.setTitle("Sao l??u d??? li???u");
			primaryStage.initStyle(StageStyle.UNIFIED);
			primaryStage.initModality(Modality.APPLICATION_MODAL);
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("../images/appIcon.png")));
			primaryStage.show();
		} catch (IOException e) {
			logger.error("exeption open frmBackupData", e);
			e.printStackTrace();
		}
	}

	@FXML
	void btnPhucHoiClick(ActionEvent event) {
		Stage primaryStage = new Stage();
		Parent root;
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/hethong/RestoreData.fxml"));
			root = loader.load();
			Scene scene = new Scene(root);
			RestoreDataController restoreDataCtrl = loader.<RestoreDataController>getController();
			primaryStage.setTitle("Ph???c h???i d??? li???u ???? sao l??u");
			primaryStage.initStyle(StageStyle.UNIFIED);
			primaryStage.initModality(Modality.APPLICATION_MODAL);
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("../images/appIcon.png")));
			primaryStage.show();
		} catch (IOException e) {
			logger.error("exeption open frmBackupData", e);
			e.printStackTrace();
		}
	}

	public static Tab tabHangHoa = null;

	@FXML
	void btnQLHangHoa(ActionEvent event) {
		String title = "H??ng H??a";
		String fxmlPath = "../fxml/danhmuc/QuanLyHangHoa.fxml";
		if (ManHinhChinhController.tabHangHoa != null) {
			tabMainContent.getSelectionModel().select(ManHinhChinhController.tabHangHoa);
			return;
		}
		Tab tab = new Tab();
		tab.setText(title);
		tab.setOnClosed(new EventHandler<Event>() {
			public void handle(Event arg0) {
				ManHinhChinhController.tabHangHoa = null;
			}
		});
		try {
			Parent root = (Parent) FXMLLoader.load(getClass().getResource(fxmlPath));
			tab.setContent(root);
			tabMainContent.getTabs().add(tab);
			tabMainContent.getSelectionModel().select(tab);
			ManHinhChinhController.tabHangHoa = tab;

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void btnHuongDanClick(ActionEvent event) {
		Runtime rt = Runtime.getRuntime();
		String url1 = "http://perfect.com.vn/huong-dan-su-dung-phan-mem-quan-ly-ban-hang.html";
		String url2 = "http://perfect.com.vn/video-huong-dan-su-dung-phan-mem-quan-ly-ban-hang.html";
		try {
			rt.exec("rundll32 url.dll,FileProtocolHandler " + url1);
			rt.exec("rundll32 url.dll,FileProtocolHandler " + url2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void btnTrucTuyenClick(ActionEvent event) {
		try {
			Runtime runTime = Runtime.getRuntime();
			Process process = runTime.exec("C:\\Program Files (x86)\\TeamViewer\\TeamViewer.exe");
		} catch (IOException e) {
			DialogConfirmController.show("Th??ng b??o!!", "B???n mu???n c??i ?????t teamviewr ", () -> {
				Runtime rt = Runtime.getRuntime();
				String url = "https://www.teamviewer.com/vi/";
				try {
					rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}, null);
			e.printStackTrace();
		}
	}

	@FXML
	void btnLienHe(ActionEvent event) {
		Stage primaryStage = new Stage();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("../fxml/trogiup/ThongTinLienHe.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("Th??ng tin li??n h???");
			primaryStage.initStyle(StageStyle.UNIFIED);
			primaryStage.initModality(Modality.APPLICATION_MODAL);
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("../images/appIcon.png")));
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void btnCapNhatClick(ActionEvent event) {
		Stage primaryStage = new Stage();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("../fxml/trogiup/CapNhat.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("C???p nh???t");
			primaryStage.initStyle(StageStyle.UNIFIED);
			primaryStage.initModality(Modality.APPLICATION_MODAL);
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("../images/appIcon.png")));
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void btnDangKyClick(ActionEvent event) {
		Stage primaryStage = new Stage();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("../fxml/trogiup/DangKy.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("????ng k??");
			primaryStage.initStyle(StageStyle.UNIFIED);
			primaryStage.initModality(Modality.APPLICATION_MODAL);
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("../images/appIcon.png")));
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
