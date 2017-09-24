PrimeFaces.locales ['ar'] = {
    closeText: 'إغلق',
    prevText: 'إلى الخلف',
    nextText: 'إلى الأمام',
    currentText: 'بداية',
    monthNames: ['ديسمبر', 'نوفمبر', 'أكتوبر', 'سبتمبر', 'أغسطس', 'يوليو', 'يونيو', 'مايو', 'ابريل', 'مارس', 'فبراير', 'يناير' ],
    monthNamesShort: ['ديسمبر', 'نوفمبر', 'أكتوبر', 'سبتمبر', 'أغسطس', 'يوليو', 'يونيو', 'مايو', 'ابريل', 'مارس', 'فبراير', 'يناير' ],
    dayNames: ['يوم الأحد‎', 'يوم الإثنين‎', 'يوم الثلاثاء‎', '‏يوم الأَرْبعاء‎', '‏يوم الخَمِيس‎', 'يوم الجُمْعَة‎‎', 'يوم السَّبْت'],
    dayNamesShort: ['الأحد‎', 'الإثنين‎', 'الثلاثاء‎', 'الأَرْبعاء‎', 'الخَمِيس‎', 'الجُمْعَة‎‎', 'السَّبْت'],
    dayNamesMin: ['الأحد‎', 'الإثنين‎', 'الثلاثاء‎', 'الأَرْبعاء‎', 'الخَمِيس‎', 'الجُمْعَة‎‎', 'السَّبْت'],
    weekHeader: 'الأسبوع',
    firstDay: 1,
    isRTL: true,
    showMonthAfterYear: false,
    yearSuffix:'' ,
    timeOnlyTitle: 'الوقت فقط' ,
    timeText: 'الوقت' ,
    hourText: 'ساعة',
    minuteText: 'دقيقة',
    secondText: 'ثانية',
    ampm: false,
    month: 'الشهر',
    week: 'الأسبوع',
    day: 'اليوم',
    allDayText: 'سا ئراليوم'
};

function daysToDisabl(date) {
	var day = date.getDay();
	return [(day != 1 && day != 2), ''];
}