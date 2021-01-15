package com.megacrit.cardcrawl.mod.replay.cards.replayxover.spireboss;

import com.megacrit.cardcrawl.cards.*;
import com.megacrit.cardcrawl.localization.*;

import com.megacrit.cardcrawl.characters.*;
import com.megacrit.cardcrawl.monsters.*;
import com.megacrit.cardcrawl.dungeons.*;

import expansioncontent.expansionContentMod;
import expansioncontent.cards.AbstractExpansionCard;
import replayTheSpire.replayxover.downfallbs;

import com.megacrit.cardcrawl.actions.*;
import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.core.*;

public class SS_Fish_SixFeetUnder extends AbstractExpansionCard
{
    public static final String ID = "Replay:SS_fish_3";
    public static final String NAME;
    public static final String DESCRIPTION;
    public static final String UPGRADE_DESCRIPTION;
    private static final CardStrings cardStrings;
    private static final int COST = 3;
    
    public SS_Fish_SixFeetUnder() {
        super(ID, "replay/ss_fish_attack", COST, AbstractCard.CardType.ATTACK, AbstractCard.CardRarity.UNCOMMON, AbstractCard.CardTarget.ENEMY);
       // this.tags.add(downfallen.STUDY_PONDFISH);
        this.tags.add(expansionContentMod.STUDY);
        this.magicNumber = this.baseMagicNumber = 6;
        this.damage = this.baseDamage = 3;
        this.exhaust = true;
        this.rawDescription = UPGRADE_DESCRIPTION;
        this.initializeDescription();
    }
    
    public void use(final AbstractPlayer p, final AbstractMonster m) {
    	for (int i=0; i<this.magicNumber; i++) {
    		if (i < this.magicNumber - 1) {
    			AbstractDungeon.actionManager.addToBottom(new DamageAction(m, new DamageInfo(p, this.damage, DamageInfo.DamageType.NORMAL), i % 2 == 0 ? AbstractGameAction.AttackEffect.SLASH_VERTICAL : AbstractGameAction.AttackEffect.SLASH_HORIZONTAL));
    		} else {
    			AbstractDungeon.actionManager.addToBottom(new DamageAction(m, new DamageInfo(p, this.damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_HEAVY));
    		}
    	}
    	/*if (!this.upgraded) {
    		AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(p, p, new WeakPower(p, 2, false), 2));
    	}*/
    }
    
    public AbstractCard makeCopy() {
        return new SS_Fish_SixFeetUnder();
    }
    
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeDamage(1);
            this.rawDescription = UPGRADE_DESCRIPTION;
            this.initializeDescription();
        }
    }
    
    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
        NAME = SS_Fish_SixFeetUnder.cardStrings.NAME;
        DESCRIPTION = SS_Fish_SixFeetUnder.cardStrings.DESCRIPTION;
        UPGRADE_DESCRIPTION = SS_Fish_SixFeetUnder.cardStrings.UPGRADE_DESCRIPTION;
    }
}
