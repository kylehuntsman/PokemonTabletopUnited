package com.github.funnygopher.ptu.gui.player.creation;

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

public class WizardController implements Initializable {

	public Accordion accordian;
	public Button btnNext0, btnNext1, btnNext2, btnNext3, btnNext4, btnNext5,
			btnNext6, btnNext7, btnNext8, btnNext9;
	public Button btnBack1, btnBack2, btnBack3, btnBack4, btnBack5, btnBack6,
			btnBack7, btnBack8, btnBack9, btnBack10;

	public TitledPane currentPane;
	public TitledPane paneStep0, paneStep1, paneStep2, paneStep3, paneStep4,
			paneStep5, paneStep6, paneStep7, paneStep8, paneStep9, paneStep10;

	// Step 2
	public Label lblBody, lblMind, lblSpirit;
	public Slider body, mind, spirit;
	public TextField txtAttributePoints;
	public int attributePoints;

	// Step 3
	public Slider hp, attack, defense, spAttack, spDefense, speed;
	public TextField txtCombatStatPoints, txtPhyEvasion, txtSpEvasion, txtSpeedEvasion;
	public int combatStatPoints;
	
	// Step 4
	public TextField txtBgName;
	public TextArea txtBgDesc;
	public TableView<SkillModifier> tableSkillsMod;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		currentPane = paneStep0;
		accordian.setExpandedPane(paneStep0);

		initStep2();
		initStep3();
		initStep4();
	}

	private void initStep2() {
		updateBodyLabel();
		updateMindLabel();
		updateSpiritLabel();
		updateAttributePoints();

		body.valueProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> ov,
					Number old_val, Number new_val) {

				updateBodyLabel();
				updateAttributePoints();

				if (attributePoints < 0) {
					body.setValue(new_val.intValue() + attributePoints);
					updateAttributePoints();
				}
			}
		});

		mind.valueProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> ov,
					Number old_val, Number new_val) {

				updateMindLabel();
				updateAttributePoints();

				if (attributePoints < 0) {
					mind.setValue(new_val.intValue() + attributePoints);
					updateAttributePoints();
				}
			}
		});

		spirit.valueProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> ov,
					Number old_val, Number new_val) {

				updateSpiritLabel();
				updateAttributePoints();

				if (attributePoints < 0) {
					spirit.setValue(new_val.intValue() + attributePoints);
					updateAttributePoints();
				}
			}
		});
	}

	private void initStep3() {
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

	private void initStep4() {
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
	private void updateAttributePoints() {
		attributePoints = 5 - (int) body.getValue() - (int) mind.getValue()
				- (int) spirit.getValue();
		txtAttributePoints.setText(Integer.toString(attributePoints));
		updateBtnNext2();
	}

	private void updateBodyLabel() {
		int bodyValue = (int) body.getValue();
		Attribute attribute = Attribute.getAttribute(bodyValue);
		lblBody.setText(Util.getDisplayName(attribute.toString()));
	}

	private void updateMindLabel() {
		int mindValue = (int) mind.getValue();
		Attribute attribute = Attribute.getAttribute(mindValue);
		lblMind.setText(Util.getDisplayName(attribute.toString()));
	}

	private void updateSpiritLabel() {
		int spiritValue = (int) spirit.getValue();
		Attribute attribute = Attribute.getAttribute(spiritValue);
		lblSpirit.setText(Util.getDisplayName(attribute.toString()));
	}

	private void updateBtnNext2() {
		if (attributePoints == 0)
			btnNext2.setDisable(false);
		else
			btnNext2.setDisable(true);
	}

	
	// Step 3 Functions
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
	
	// Step 4 Functions
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

	public void toStep10(ActionEvent event) {
		goToPane(paneStep10);
	}
}
