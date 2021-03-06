/*******************************************************************************
 * riscVivid - A RISC-V processor simulator.
 * (C)opyright 2013-2016 The riscVivid project, University of Augsburg, Germany
 * https://github.com/unia-sik/riscVivid
 *
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program, see <LICENSE>. If not, see
 * <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package riscVivid.branchPrediction;

import riscVivid.datatypes.BranchPredictorState;

public class StaticBranchPredictor implements BranchPredictor
{
	private boolean prediction;

	public StaticBranchPredictor(boolean generalPrediction)
	{
		prediction = generalPrediction;
	}
	
	public boolean predictsTaken()
	{
		return prediction;
	}
	
	public boolean predictsNotTaken()
	{
		return !prediction;
	}

	public BranchPredictorState getState()
	{
		if(prediction)
		{
			return BranchPredictorState.PREDICT_TAKEN;
		}
		else
		{
			return BranchPredictorState.PREDICT_NOT_TAKEN;
		}
	}

	public void updateState(boolean jumpTaken)
	{
		// do nothing - this is a static predictor
	}

	public void reset()
	{
		// do nothing - this is a static predictor
	}
}
