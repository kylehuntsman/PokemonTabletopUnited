package com.github.funnygopher.ptu.charactercreation.gui;

import com.github.funnygopher.ptu.Skill;
import com.github.funnygopher.ptu.trainer.Attribute;
import com.github.funnygopher.ptu.util.Util;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class CharacterCreationController implements Initializable {

	public Accordion accordian;
	public Button btnNext0, btnNext1, btnNext2, btnNext3, btnNext4, btnNext5,
			btnNext6, btnNext7, btnNext8;
	public Button btnBack1, btnBack2, btnBack3, btnBack4, btnBack5, btnBack6,
			btnBack7, btnBack8, btnBack9;

	public TitledPane currentPane;
	public TitledPane paneStep0, paneStep1, paneStep2, paneStep3, paneStep4,
			paneStep5, paneStep6, paneStep7, paneStep8, paneStep9;


	// Step 2
	public Slider hp, attack, defense, spAttack, spDefense, speed;
	public TextField txtCombatStatPoints, txtPhyEvasion, txtSpEvasion, txtSpeedEvasion;
	public int combatStatPoints;
	
	// Step 3
	public TextField txtBgName;
	public TextArea txtBgDesc;
	public TableView<SkillModifier> tableSkillsMod;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		currentPane = paneStep0;
		accordian.setExpandedPane(paneStep0);

		initStep2();
		initStep3();
	}

	private void initStep2() {
		updateCombatStatPoints();
		
		hp.valueProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> ov,
					Number old_val, Number new_val) {

				updateCombatStatPoints();

				if (combatStatPoints < 0) {
					hp.setValue(new_val.intValue() + combatStatPoints);
					updateCombatStatPoints();
				}
			}
		});
		
		attack.valueProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> ov,
					Number old_val, Number new_val) {

				updateCombatStatPoints();

				if (combatStatPoints < 0) {
					attack.setValue(new_val.intValue() + combatStatPoints);
					updateCombatStatPoints();
				}
			}
		});
		
		defense.valueProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> ov,
					Number old_val, Number new_val) {

				updateCombatStatPoints();

				if (combatStatPoints < 0) {
					defense.setValue(new_val.intValue() + combatStatPoints);
					updateCombatStatPoints();
				}
			}
		});
		
		spAttack.valueProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> ov,
					Number old_val, Number new_val) {

				updateCombatStatPoints();

				if (combatStatPoints < 0) {
					spAttack.setValue(new_val.intValue() + combatStatPoints);
					updateCombatStatPoints();
				}
			}
		});
		
		spDefense.valueProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> ov,
					Number old_val, Number new_val) {

				updateCombatStatPoints();

				if (combatStatPoints < 0) {
					spDefense.setValue(new_val.intValue() + combatStatPoints);
					updateCombatStatPoints();
				}
			}
		});
		
		speed.valueProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> ov,
					Number old_val, Number new_val) {

				updateCombatStatPoints();

				if (combatStatPoints < 0) {
					speed.setValue(new_val.intValue() + combatStatPoints);
					updateCombatStatPoints();
				}
			}
		});
	}

	private void initStep3() {
		tableSkillsMod = new TableView<>();
		tableSkillsMod.setEditable(true);
		tableSkillsMod.setItems(FXCollections.observableArrayList(new SkillModifier(Skill.ADEPT, Skill.EXPERT)));

		TableColumn<SkillModifier, Skill> rankUpCol = new TableColumn<>("Rank Up");
		rankUpCol.setMinWidth(50);
		rankUpCol.setPrefWidth(150);
		rankUpCol.setCellValueFactory(new PropertyValueFactory<>("rankUp"));
		rankUpCol.setCellFactory(ComboBoxTableCell.<SkillModifier, Skill>forTableColumn(Skill.values()));
		rankUpCol.setEditable(false);

		tableSkillsMod.getColumns().addAll(rankUpCol);
	}

	public class SkillModifier {
		private final SimpleObjectProperty<Skill> rankUp, rankDown;

		private SkillModifier(Skill rankUp, Skill rankDown) {
			this.rankUp = new SimpleObjectProperty<Skill>(rankUp);
			this.rankDown = new SimpleObjectProperty<Skill>(rankDown);
		}

		public Skill getRankUp() {
			return rankUp.get();
		}

		public Skill getRankDown() {
			return rankDown.get();
		}
	}
	
	// Step 2 Functions
	private void updateCombatStatPoints() {
		combatStatPoints = 45 - (int) hp.getValue() - (int) attack.getValue()
				- (int) defense.getValue() - (int) spAttack.getValue()
				- (int) spDefense.getValue() - (int) speed.getValue();
		txtCombatStatPoints.setText(Integer.toString(combatStatPoints));
		
		updateEvasions();
		updateBtnNext3();
	}

	private int getEvasion(double statValue) {
		return (int) (statValue / 5);
	}
	
	private void updateEvasions() {
		txtPhyEvasion.setText(Integer.toString(getEvasion(defense.getValue())));
		txtSpEvasion.setText(Integer.toString(getEvasion(spDefense.getValue())));
		txtSpeedEvasion.setText(Integer.toString(getEvasion(speed.getValue())));
	}
	
	private void updateBtnNext3() {
		if (combatStatPoints == 0)
			btnNext3.setDisable(false);
		else
			btnNext3.setDisable(true);
	}
	
	// Step 3 Functions
	private void addSkillsMod() {
	}

	// Navigation
	private void goToPane(TitledPane pane) {
		currentPane.setCollapsible(true);
		currentPane.setDisable(true);
		
		pane.setDisable(false);
		accordian.setExpandedPane(pane);
		pane.setCollapsible(false);
		
		currentPane = pane;
	}

	public void toStep0(ActionEvent event) {
		goToPane(paneStep0);
	}

	public void toStep1(ActionEvent event) {
		goToPane(paneStep1);
	}

	public void toStep2(ActionEvent event) {
		goToPane(paneStep2);
	}

	public void toStep3(ActionEvent event) {
		goToPane(paneStep3);
	}

	public void toStep4(ActionEvent event) {
		goToPane(paneStep4);
	}

	public void toStep5(ActionEvent event) {
		goToPane(paneStep5);
	}

	public void toStep6(ActionEvent event) {
		goToPane(paneStep6);
	}

	public void toStep7(ActionEvent event) {
		goToPane(paneStep7);
	}

	public void toStep8(ActionEvent event) {
		goToPane(paneStep8);
	}

	public void toStep9(ActionEvent event) {
		goToPane(paneStep9);
	}
}
