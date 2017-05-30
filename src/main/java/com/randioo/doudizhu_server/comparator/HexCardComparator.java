package com.randioo.doudizhu_server.comparator;

import java.util.Comparator;

import org.springframework.stereotype.Component;

import com.randioo.doudizhu_server.util.CardTools;

@Component("hexCardComparator")
public class HexCardComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		return CardTools.toNum(o1) - CardTools.toNum(o2);
	}

}
