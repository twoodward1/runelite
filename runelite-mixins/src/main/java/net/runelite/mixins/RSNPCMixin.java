/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.mixins;

import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.rs.api.RSNPC;
import net.runelite.rs.api.RSNPCComposition;

@Mixin(RSNPC.class)
public abstract class RSNPCMixin implements RSNPC
{
	@Inject
	private int npcIndex;

	@Inject
	@Override
	public int getId()
	{
		RSNPCComposition composition = getComposition();
		return composition == null ? -1 : composition.getId();
	}

	@Inject
	@Override
	public String getName()
	{
		RSNPCComposition composition = getComposition();
		return composition == null ? null : composition.getName().replace('\u00A0', ' ');
	}

	@Inject
	@Override
	public int getCombatLevel()
	{
		RSNPCComposition composition = getComposition();
		return composition == null ? -1 : composition.getCombatLevel();
	}

	@Inject
	@Override
	public int getIndex()
	{
		return npcIndex;
	}

	@Inject
	@Override
	public void setIndex(int id)
	{
		npcIndex = id;
	}
}
